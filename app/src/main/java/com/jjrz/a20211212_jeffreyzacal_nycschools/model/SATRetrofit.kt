package com.jjrz.a20211212_jeffreyzacal_nycschools.model


import androidx.lifecycle.ViewModelProvider
import com.google.android.material.internal.ContextUtils.getActivity
import com.jjrz.a20211212_jeffreyzacal_nycschools.utility.DebugHelper.Companion.LogKitty
import com.jjrz.a20211212_jeffreyzacal_nycschools.view.MainActivity
import com.jjrz.a20211212_jeffreyzacal_nycschools.viewmodel.NycSchoolsVieModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.security.AccessController.getContext


class SATRetrofit {
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
                    LogKitty("SATs API response : " + response.body()?.size)
                    response.body()?.forEach {
                        LogKitty(it.toString())
                        myMap.put(it.dbn.toString(), it)
                    }
                    LogKitty("SAT HashMap size : " + myMap.size)
                }
            }

            override fun onFailure(call: Call<SatScores>, t: Throwable) {
            }

        })
        return myMap
    }

    interface SATService {
        @GET("f9bf-2cp4.json")
        fun getAllSATScores(): Call<SatScores>
    }
}