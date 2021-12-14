package com.jjrz.a20211212_jeffreyzacal_nycschools.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SATRetrofit
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SatScoresItem
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SchoolsItem
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SchoolsRetrofit

class NycSchoolsViewModel : ViewModel() {
    private val mySchoolRetrofit = SchoolsRetrofit()
    private val mySATRetrofit = SATRetrofit()
    var mySchools =
        MutableLiveData<MutableList<SchoolsItem>>().apply { value = mySchoolRetrofit.getSchools().toMutableList() }
    var satScores = MutableLiveData<HashMap<String, SatScoresItem>>().apply {
        value = mySATRetrofit.getScores()
    }

    fun getScores(dBn: String): SatScoresItem? = satScores.value?.get(dBn)

    fun getScoresCount(): Int = satScores.value.let {
        it?.size
    } ?: 0

    fun getSchools(): MutableList<SchoolsItem>? = mySchools.value

    fun getSchoolsCount(): Int = mySchools.value.let {
        it?.size
    } ?: 0
}

