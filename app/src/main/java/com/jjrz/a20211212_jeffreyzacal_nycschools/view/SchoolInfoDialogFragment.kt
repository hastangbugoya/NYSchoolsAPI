package com.jjrz.a20211212_jeffreyzacal_nycschools.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.jjrz.a20211212_jeffreyzacal_nycschools.R
import com.jjrz.a20211212_jeffreyzacal_nycschools.databinding.SchoolDetailsBinding
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SchoolsItem
import com.jjrz.a20211212_jeffreyzacal_nycschools.viewmodel.NycSchoolsViewModel


class SchoolInfoDialogFragment() : DialogFragment() {
    val viewModel = ViewModelProvider(requireActivity()).get(NycSchoolsViewModel::class.java)
    fun onCreate(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.school_details, container, false)
    }

    override fun onStart() {
        val binding = SchoolDetailsBinding.inflate(LayoutInflater.from(requireContext()))
        super.onStart()
        val intent = this.arguments
        val bundle = intent?.getSerializable("value")
        val school = bundle as SchoolsItem
        dialog?.window?.setLayout(
            resources.displayMetrics.widthPixels,
            (resources.displayMetrics.heightPixels * 0.80).toInt()
        )
        binding.apply {
            textSchoolName.text = "Test"
            textOverview.text = "Test2"
            textPhone.text = "Test3"
            textSchoolLocation.text = "Test4"
            textSchoolEmail.text = "Test5"
            textZip.text = "Test6"
            imgOkIcon.setOnClickListener {
                activity?.onBackPressed()
            }
            imgDirectionsIcon.setOnClickListener {
                //TODO : change uri to address or lnglat
                val gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }
        }

    }
}