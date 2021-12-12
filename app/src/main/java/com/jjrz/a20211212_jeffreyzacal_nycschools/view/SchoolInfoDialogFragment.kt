package com.jjrz.a20211212_jeffreyzacal_nycschools.view

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.jjrz.a20211212_jeffreyzacal_nycschools.R


class SchoolInfoDialogFragment() : DialogFragment() {

     fun onCreate(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        return inflater.inflate(R.layout.school_details, container, false)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            resources.displayMetrics.widthPixels,
            (resources.displayMetrics.heightPixels * 0.80).toInt()
        )

    }
}