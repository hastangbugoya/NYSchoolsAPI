package com.jjrz.a20211212_jeffreyzacal_nycschools.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jjrz.a20211212_jeffreyzacal_nycschools.R
import com.jjrz.a20211212_jeffreyzacal_nycschools.databinding.ActivityMainBinding
import com.jjrz.a20211212_jeffreyzacal_nycschools.viewmodel.NycSchoolsVieModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val myNYCSchoolsViewModel = ViewModelProvider(this).get(NycSchoolsVieModel::class.java)
        var adapter = SchoolsRecyclerViewAdapter()
        var binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        setContentView(R.layout.activity_main)
        myNYCSchoolsViewModel.mySchools.observe(this, Observer {

        })
    }
}