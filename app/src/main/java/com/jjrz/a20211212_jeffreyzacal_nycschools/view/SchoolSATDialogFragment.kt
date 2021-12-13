package com.jjrz.a20211212_jeffreyzacal_nycschools.view

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.jjrz.a20211212_jeffreyzacal_nycschools.R
import com.jjrz.a20211212_jeffreyzacal_nycschools.databinding.SchoolSatScoresBinding


class SchoolSATDialogFragment() : DialogFragment() {

     fun onCreate(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        return inflater.inflate(R.layout.school_sat_scores, container, false)
    }

    override fun onStart() {
        val binding = SchoolSatScoresBinding.inflate(LayoutInflater.from(requireContext()))
        super.onStart()
        dialog?.window?.setLayout(
            resources.displayMetrics.widthPixels,
            (resources.displayMetrics.heightPixels * 0.80).toInt()
        )
        binding.textSchoolName.text = "Test 1"
        binding.textNumOfSatTestTakers.text = "9999"
        binding.textSatCriticalReadingAvgScore.text = "25"
        binding.textSatMathAvgScore.text = "50"
        binding.textSatWritingAvgScore.text = "0"
        binding.imgOkIcon.setOnClickListener() {
            activity?.onBackPressed()
        }
    }
}