package com.jjrz.a20211212_jeffreyzacal_nycschools.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jjrz.a20211212_jeffreyzacal_nycschools.R
import com.jjrz.a20211212_jeffreyzacal_nycschools.databinding.ActivityMainBinding
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SATRetrofit
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SchoolsRetrofit
import com.jjrz.a20211212_jeffreyzacal_nycschools.utility.DebugHelper.Companion.LogKitty
import com.jjrz.a20211212_jeffreyzacal_nycschools.viewmodel.NycSchoolsViewModel

class MainActivity : AppCompatActivity() {
    private val mySchoolRetrofit = SchoolsRetrofit()

    override fun onCreate(savedInstanceState: Bundle?) {
        val myNYCSchoolsViewModel : NycSchoolsViewModel by viewModels()
        val viewModel = ViewModelProvider(this).get(NycSchoolsViewModel::class.java)
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)
        var adapter = SchoolsAdapter()
        binding.schoolsRecyclerview.adapter = adapter

        myNYCSchoolsViewModel.mySchools.observe(this, {
            LogKitty("Schools changed")
            LogKitty(myNYCSchoolsViewModel.getSchoolsCount().toString())
            adapter.updateList(it)
        })

        myNYCSchoolsViewModel.satScores.observe(this, {
            LogKitty("Scores changed")
            LogKitty(myNYCSchoolsViewModel.getScoresCount().toString())
        })

        mySchoolRetrofit.getSchools()

        adapter.addStuff()
        LogKitty(myNYCSchoolsViewModel.getSchoolsCount().toString())
        LogKitty("ViewModel Schools count > " + myNYCSchoolsViewModel.getSchoolsCount())
    }
}