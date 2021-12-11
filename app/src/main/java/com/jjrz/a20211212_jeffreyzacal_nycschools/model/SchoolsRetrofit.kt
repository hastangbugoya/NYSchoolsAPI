package com.jjrz.a20211212_jeffreyzacal_nycschools.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class SchoolsRetrofit {

    private val schoolsService = createRetrofit().create(SchoolsService::class.java)

    private fun createRetrofit() = Retrofit.Builder().baseUrl("https://data.cityofnewyork.us/resource/").addConverterFactory(GsonConverterFactory.create()).build()

    internal interface SchoolsService {
        @GET("s3k6-pzi2.json")
        fun searchResults(): List<schoolsItem>?
    }

    fun GetSchools(): List<schoolsItem>? {
        return schoolsService.searchResults()
    }
}