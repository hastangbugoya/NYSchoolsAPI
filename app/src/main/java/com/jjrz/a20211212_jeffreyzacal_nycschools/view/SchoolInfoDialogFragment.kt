package com.jjrz.a20211212_jeffreyzacal_nycschools.view

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.jjrz.a20211212_jeffreyzacal_nycschools.R
import com.jjrz.a20211212_jeffreyzacal_nycschools.databinding.SchoolDetailsBinding


class SchoolInfoDialogFragment() : DialogFragment() {

     fun onCreate(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        return inflater.inflate(R.layout.school_details, container, false)
    }

    override fun onStart() {
        val binding = SchoolDetailsBinding.inflate(LayoutInflater.from(requireContext()))
        super.onStart()
        dialog?.window?.setLayout(
            resources.displayMetrics.widthPixels,
            (resources.displayMetrics.heightPixels * 0.80).toInt()
        )
        binding.textSchoolName.text = "Test"
        binding.textOverview.text = "Test2"
        binding.textPhone.text = "Test3"
        binding.textSchoolLocation.text = "Test4"
        binding.textSchoolEmail.text = "Test5"
        binding.textZip.text = "Test6"
        binding.imgOkIcon.setOnClickListener() {
            activity?.onBackPressed()
        }
    }
}