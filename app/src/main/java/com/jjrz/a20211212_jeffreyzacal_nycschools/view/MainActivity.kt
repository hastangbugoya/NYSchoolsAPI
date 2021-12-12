package com.jjrz.a20211212_jeffreyzacal_nycschools.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.PagerSnapHelper
import com.jjrz.a20211212_jeffreyzacal_nycschools.R
import com.jjrz.a20211212_jeffreyzacal_nycschools.databinding.ActivityMainBinding
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SchoolsRetrofit
import com.jjrz.a20211212_jeffreyzacal_nycschools.utility.DebugHelper.Companion.LogKitty
import com.jjrz.a20211212_jeffreyzacal_nycschools.viewmodel.NycSchoolsVieModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogKitty("Main1")
        val myNYCSchoolsViewModel = ViewModelProvider(this).get(NycSchoolsVieModel::class.java)

        var binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        var adapter = SchoolsRecyclerViewAdapter()
        val snapHelper = PagerSnapHelper()
        LogKitty("Main2")
        setContentView(R.layout.activity_main)
        LogKitty("Main3")
        adapter.setSchools(myNYCSchoolsViewModel.getSchools())
        LogKitty("Main4")
        binding.schoolsRecyclerview.adapter = adapter
        LogKitty("Main5 > " + myNYCSchoolsViewModel.getSchoolsCount())
        myNYCSchoolsViewModel.mySchools.observe(this, Observer {
            LogKitty("Main6 > " + myNYCSchoolsViewModel.getSchoolsCount())
            adapter.setSchools(it)
        })
    }
}