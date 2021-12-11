package com.jjrz.a20211212_jeffreyzacal_nycschools.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class SATRetrofit {

    private val sATService = createRetrofit().create(SATService::class.java)
    val baseURL = "https://data.cityofnewyork.us/resource/f9bf-2cp4.json"

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    internal interface SATService {
        @GET
        fun searchResults(): Call<SatScores?>?
    }

    fun GetScores(count: Int): Call<SatScores?>? {
        return sATService.searchResults()
    }
}