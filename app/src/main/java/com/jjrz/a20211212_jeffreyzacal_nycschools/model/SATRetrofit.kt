package com.jjrz.a20211212_jeffreyzacal_nycschools.model


import android.util.Log
import com.jjrz.a20211212_jeffreyzacal_nycschools.utility.DebugHelper.Companion.LogKitty
import com.jjrz.a20211212_jeffreyzacal_nycschools.viewmodel.NycSchoolsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class SATRetrofit {
    val myVM = NycSchoolsViewModel()
    var myMap = HashMap<String, SatScoresItem>()
    fun getScores(): HashMap<String, SatScoresItem> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us/resource/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(SATService::class.java)
        val call = service.getAllSATScores()
        call.enqueue(object : Callback<SatScores> {
            override fun onResponse(call: Call<SatScores>, response: Response<SatScores>) {
                if (response.code() == 200) {
                    LogKitty("AASAT SATs API response : " + response.body()?.size)
                    response.body()?.forEach {
//                        LogKitty(it.toString())
                        myMap.put(it.dbn.toString(), it)
                    }
                    myVM.satScores.value = myMap
                    myVM.satScores.postValue(myMap)
                    LogKitty("ABSAT SAT HashMap size : " + myMap.size)
                }
            }

            override fun onFailure(call: Call<SatScores>, t: Throwable) {
                Log.d("Getting SAT scores : ", "Fail : $t")
            }

        })
        return myMap
    }

    interface SATService {
        @GET("f9bf-2cp4.json")
        fun getAllSATScores(): Call<SatScores>
    }
}