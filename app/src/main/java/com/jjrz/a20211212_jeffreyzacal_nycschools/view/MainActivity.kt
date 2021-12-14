package com.jjrz.a20211212_jeffreyzacal_nycschools.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.jjrz.a20211212_jeffreyzacal_nycschools.R
import com.jjrz.a20211212_jeffreyzacal_nycschools.databinding.ActivityMainBinding
import com.jjrz.a20211212_jeffreyzacal_nycschools.utility.DebugHelper.Companion.LogKitty
import com.jjrz.a20211212_jeffreyzacal_nycschools.viewmodel.NycSchoolsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var adapter : SchoolsAdapter
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        adapter = SchoolsAdapter()

        binding.schoolsRecyclerview.adapter = adapter
        val myNYCSchoolsViewModel = ViewModelProvider(this).get(NycSchoolsViewModel::class.java).also {
            adapter.updateList(it.getSchools())
            LogKitty("XXQW" + it.getSchoolsCount().toString())
        }

        adapter.addStuff()
        LogKitty("ViewModel Schools count > " + myNYCSchoolsViewModel.getSchoolsCount())
    }

}