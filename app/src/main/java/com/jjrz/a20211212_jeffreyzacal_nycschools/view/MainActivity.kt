package com.jjrz.a20211212_jeffreyzacal_nycschools.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jjrz.a20211212_jeffreyzacal_nycschools.R
import com.jjrz.a20211212_jeffreyzacal_nycschools.viewmodel.NycSchoolsVieModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val myNYCSchoolsViewModel = ViewModelProvider(this).get(NycSchoolsVieModel::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myNYCSchoolsViewModel.mySchools.observe(this, Observer {

        })
    }
}