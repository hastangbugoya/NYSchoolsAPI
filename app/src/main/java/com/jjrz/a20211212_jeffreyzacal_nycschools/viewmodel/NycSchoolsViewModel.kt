package com.jjrz.a20211212_jeffreyzacal_nycschools.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.*



class NycSchoolsVieModel : ViewModel(){
    private val mySchoolRetrofit = SchoolsRetrofit()
    private val mySATRetrofit = SATRetrofit()
    var mySchools = MutableLiveData<List<SchoolsItem>>().apply { value = mySchoolRetrofit.getSchools() }
    var satScores = MutableLiveData<HashMap<String,SatScoresItem>>().apply { value = mySATRetrofit.getScores() }

    fun getScores(dBn : String) : SatScoresItem? = satScores.value?.get(dBn)

    fun getSchools() : List<SchoolsItem>? = mySchools.value
 }

