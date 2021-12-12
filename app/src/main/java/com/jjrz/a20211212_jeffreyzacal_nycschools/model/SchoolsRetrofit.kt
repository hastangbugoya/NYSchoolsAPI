package com.jjrz.a20211212_jeffreyzacal_nycschools.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.jjrz.a20211212_jeffreyzacal_nycschools.utility.DebugHelper.Companion.LogKitty
import com.jjrz.a20211212_jeffreyzacal_nycschools.viewmodel.NycSchoolsVieModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class SchoolsRetrofit {
    fun getSchools() : List<SchoolsItem> {
        LogKitty("Hello there 1")
        var myList = mutableListOf<SchoolsItem>()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us/resource/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(SchoolsService::class.java)
        val call = service.getAllSchools()
        LogKitty("Hello there 2")
        call.enqueue(object : Callback<Schools> {
            override fun onResponse(call: Call<Schools>, response: Response<Schools>) {
                LogKitty("Hello there 3")
                if (response.code() == 200) {
                    LogKitty("Hello Schools results : " + response.body()?.size)

                    response.body()?.forEach {
                        myList.add(it)
                        LogKitty("School : " + it.toString())
                    }
                            LogKitty ("Schools added to list : " + myList.size)
                }
            }

            override fun onFailure(call: Call<Schools>, t: Throwable) {
                LogKitty("Fail : $t")
            }
        })
        LogKitty("Schools List count " + myList.size)
        return myList
    }

    interface SchoolsService {
        @GET("s3k6-pzi2.json")
        fun getAllSchools(): Call<Schools>
    }

}