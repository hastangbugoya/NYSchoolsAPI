package com.jjrz.a20211212_jeffreyzacal_nycschools.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SATRetrofit
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SatScoresItem
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SchoolsRetrofit
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.schoolsItem


class NycSchoolsVieModel : ViewModel(){
    val mySchoolRetrofit = SchoolsRetrofit()
    val mySATRetrofit = SATRetrofit()
    var mySchools = MutableLiveData<List<schoolsItem>>().apply {  value = mySchoolRetrofit.GetSchools() }
    var satScores = MutableLiveData<HashMap<String,SatScoresItem>>()

    fun GetScores(dBn : String) : SatScoresItem? = satScores.value?.get(dBn)
}