package com.jjrz.a20211212_jeffreyzacal_nycschools.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jjrz.a20211212_jeffreyzacal_nycschools.databinding.SchoolsListItemBinding
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SchoolsItem
import com.jjrz.a20211212_jeffreyzacal_nycschools.utility.DebugHelper.Companion.LogKitty

class SchoolsRecyclerViewAdapter : RecyclerView.Adapter<SchoolsRecyclerViewAdapter.SchoolsViewHolder>() {
    private var schoolsList: List<SchoolsItem>? = null


    fun SchoolsRecyclerViewAdapter(schools: List<SchoolsItem>?) {
        LogKitty("SchoolsRecyclerViewAdapter")
        this.schoolsList = schools
    }

    fun setSchools(schools: List<SchoolsItem>?) {
        if (schools != null) {
            LogKitty("setSchools > " + schools.size)
        }
        this.schoolsList = schools
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolsViewHolder {
        LogKitty("onCreateViewHolder1")
        val binding: SchoolsListItemBinding = SchoolsListItemBinding.inflate(
            LayoutInflater.from(
                parent.context
            ),
            parent,
            false
        )
        LogKitty("onCreateViewHolder2")
        return SchoolsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SchoolsViewHolder, position: Int) {
        val schoolItem: SchoolsItem = schoolsList!![position]
        LogKitty("onBindViewHolder > " + schoolItem.school_name.toString())
        holder.binding.textSchoolName.text = schoolItem.school_name.toString()
        holder.binding.textSchoolLocation.text = schoolItem.location.toString()
        holder.binding.textSchoolEmail.text = schoolItem.school_email.toString()
        holder.binding.textSchoolWebsite.text = schoolItem.website.toString()
        holder.binding.imgInfo.setOnClickListener{

        }
    }

    class SchoolsViewHolder(binding: SchoolsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: SchoolsListItemBinding = binding
    }

    override fun getItemCount(): Int {
        return schoolsList.let{ schoolsList?.size} ?: 0
    }

}