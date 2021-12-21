package com.jjrz.a20211212_jeffreyzacal_nycschools.view

import android.content.ContentProvider
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.jjrz.a20211212_jeffreyzacal_nycschools.databinding.SchoolsListItemBinding
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SchoolsItem
import com.jjrz.a20211212_jeffreyzacal_nycschools.utility.DebugHelper.Companion.LogKitty
import java.security.AccessController.getContext

class SchoolsRecyclerViewAdapter :
    RecyclerView.Adapter<SchoolsRecyclerViewAdapter.SchoolsViewHolder>() {
    private var schoolsList = mutableListOf<SchoolsItem>()

    fun setSchools(schools: MutableList<SchoolsItem>?) {
        if (schools != null) {
            schoolsList = schools
        }
        notifyDataSetChanged()
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
        LogKitty("onBindViewHolder")
        val schoolItem: SchoolsItem = schoolsList!![position]
        holder.binding.apply {
            textSchoolName.text = schoolItem.school_name.toString()
            textSchoolLocation.text =
                "{$schoolItem.primary_address_line_1.toString()}, ${schoolItem.city.toString()} {${schoolItem.zip.toString()}"
            textSchoolEmail.text = schoolItem.school_email.toString()
            textSchoolWebsite.text = schoolItem.website.toString()
            imgInfo.setOnClickListener {
                val intent = Intent(holder.binding.textSchoolWebsite.context, SchoolInfoDialogFragment::class.java).apply {
                    val bundle = Bundle()
                    bundle.putSerializable("value", schoolItem)
                    this.putExtras(bundle)
                }

            }
        }

    }

    inner class SchoolsViewHolder(binding: SchoolsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: SchoolsListItemBinding = binding
    }

    override fun getItemCount(): Int {
        return schoolsList.let { schoolsList?.size } ?: 0
    }

    fun addStuff() {
        LogKitty("addStuff")
        schoolsList.add(SchoolsItem("1234","Long BEach","1234", "23rd Street","1","2","asdadfac qweqwe","2344","2312 21","12312@123123","This School","1234","www.www.www","12345"))
        schoolsList.add(SchoolsItem("1234","Long BEach","1234", "23rd Street","1","2","asdadfac qweqwe","2344","2312 21","12312@123123","This School","1234","www.www.www","12345"))
        schoolsList.add(SchoolsItem("1234","Long BEach","1234", "23rd Street","1","2","asdadfac qweqwe","2344","2312 21","12312@123123","This School","1234","www.www.www","12345"))
        notifyDataSetChanged()
        LogKitty("Adapter List > " + (schoolsList.size))
    }

}