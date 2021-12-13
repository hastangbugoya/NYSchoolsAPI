package com.jjrz.a20211212_jeffreyzacal_nycschools.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.jjrz.a20211212_jeffreyzacal_nycschools.R
import com.jjrz.a20211212_jeffreyzacal_nycschools.databinding.SchoolSatScoresBinding
import com.jjrz.a20211212_jeffreyzacal_nycschools.viewmodel.NycSchoolsVieModel


class SchoolSATDialogFragment() : DialogFragment() {

    fun onCreate(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.school_sat_scores, container, false)
    }

    override fun onStart() {
        val binding = SchoolSatScoresBinding.inflate(LayoutInflater.from(requireContext()))
        super.onStart()
        dialog?.window?.setLayout(
            resources.displayMetrics.widthPixels,
            (resources.displayMetrics.heightPixels * 0.80).toInt()
        )
        binding.apply {
            textSchoolName.text = "Test 1"
            textNumOfSatTestTakers.text = "9999"
            textSatCriticalReadingAvgScore.text = "25"
            textSatMathAvgScore.text = "50"
            textSatWritingAvgScore.text = "0"
            imgOkIcon.setOnClickListener() {
                activity?.onBackPressed()
            }
        }

    }
}