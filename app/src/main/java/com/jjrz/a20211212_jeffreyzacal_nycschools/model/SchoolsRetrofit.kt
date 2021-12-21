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


class SchoolsRetrofit {

    fun getSchools() {
        val myVM = NycSchoolsViewModel()
        val mySATRetrofit = SATRetrofit()
        var myList = mutableListOf<SchoolsItem>()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us/resource/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(SchoolsService::class.java)
        val call = service.getAllSchools()

        call.enqueue(object : Callback<Schools> {

            override fun onResponse(call: Call<Schools>, response: Response<Schools>) {
                if (response.code() == 200) {
                    var i = 1
                    LogKitty("AABBA Schools API results : " + response.body()?.size)
                    response.body().let {
                        if (it != null) {
                            myList = it.toMutableList()
                        }
                    }
//                    response.body()?.forEach {
//                        myList.add(it)
//                        //LogKitty("(#$i School : $it")
//                        i++
//                    }
                    myVM.mySchools.postValue(myList)
                    LogKitty("AABBB Schools added to list : " + myList.size)
                    mySATRetrofit.getScores()
                }
            }

            override fun onFailure(call: Call<Schools>, t: Throwable) {
                Log.d("Getting schools list : ", "Fail : $t")
            }
        })
    }

    interface SchoolsService {
        @GET("s3k6-pzi2.json")
        fun getAllSchools(): Call<Schools>
    }

}