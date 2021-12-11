package com.jjrz.a20211212_jeffreyzacal_nycschools.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View.OnTouchListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.jjrz.a20211212_jeffreyzacal_nycschools.databinding.SchoolsListItemBinding
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.schoolsItem
import kotlin.math.log

class SchoolsRecyclerViewAdapter {
    private var schoolsList: List<schoolsItem>? = null

    fun SchoolsRecyclerViewAdapter(schools: List<schoolsItem>?) {
        this.schoolsList = schools
    }

    fun setSchools(schools: List<schoolsItem>?) {
        this.schoolsList = schools
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolsViewHolder {
        val binding: SchoolsListItemBinding = SchoolsListItemBinding.inflate(
            LayoutInflater.from(
                parent.context
            ),
            parent,
            false
        )
        return SchoolsViewHolder(binding)
    }

    fun onBindViewHolder(holder: SchoolsViewHolder, position: Int) {
        val schoolItem: schoolsItem = schoolsList!![position]
        holder.binding.textSchoolName.text = schoolItem.school_name.toString()
        holder.binding.textSchoolLocation.text = schoolItem.location.toString()
    }

    fun getSchoolCount(): Int {
        return schoolsList.let{ schoolsList?.size} ?: 0
    }

    class SchoolsViewHolder(binding: SchoolsListItemBinding) :
        RecyclerView.ViewHolder(binding.getRoot()) {
        var binding: SchoolsListItemBinding

        init {
            this.binding = binding
        }
    }
}