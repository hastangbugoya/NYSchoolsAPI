package com.jjrz.a20211212_jeffreyzacal_nycschools.model

import android.util.Log
import androidx.lifecycle.LiveData
import com.jjrz.a20211212_jeffreyzacal_nycschools.BuildConfig
import com.jjrz.a20211212_jeffreyzacal_nycschools.utility.DebugHelper.Companion.LogKitty
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class SchoolsRetrofit {
    fun getSchools() : MutableList<SchoolsItem> {
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
//                    response.body().let {
//                        if (it != null) {
//                            myList = it.toMutableList()
//                        }
//                    } // Use this when it works
                    response.body()?.forEach {
                        myList.add(it)
                        LogKitty("(#$i School : $it")
                        i++
                    }
                    LogKitty("AABBB Schools added to list : " + myList.size)
                }
            }

            override fun onFailure(call: Call<Schools>, t: Throwable) {
                Log.d("Getting schools list : ","Fail : $t")
            }
        })
        return myList
    }

    interface SchoolsService {
        @GET("s3k6-pzi2.json")
        fun getAllSchools(): Call<Schools>
    }

}