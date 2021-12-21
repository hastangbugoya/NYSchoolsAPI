package com.jjrz.a20211212_jeffreyzacal_nycschools.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jjrz.a20211212_jeffreyzacal_nycschools.databinding.SchoolsListItemBinding
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SchoolsItem
import com.jjrz.a20211212_jeffreyzacal_nycschools.model.SchoolsRetrofit
import com.jjrz.a20211212_jeffreyzacal_nycschools.utility.DebugHelper


class SchoolsAdapter : RecyclerView.Adapter<SchoolsAdapter.SchoolViewHolder>() {
    private var schools: MutableList<SchoolsItem> = mutableListOf()
    fun updateList(new_list: MutableList<SchoolsItem>?) {
        if (new_list != null) {
            schools = new_list
        }
        notifyDataSetChanged()
    }

    inner class SchoolViewHolder(val binding: SchoolsListItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        val binding =
            SchoolsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SchoolViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        val school = schools[position]
        with(holder.binding) {
            school.apply {
                textSchoolName.text = school_name
                textSchoolLocation.text =
                    "$primary_address_line_1, $city $zip"
                textSchoolEmail.text = school_email
                textSchoolWebsite.text = website
            }
        }
    }

    override fun getItemCount(): Int {
        return schools.size
    }

    fun addStuff() {
        DebugHelper.LogKitty("addStuff")
        schools.add(
            SchoolsItem(
                "12342",
                "Long BEach",
                "1234",
                "23rd Street",
                "1",
                "2",
                "asdadfac qweqwe",
                "2344",
                "2312 21",
                "12312@123123",
                "ASDASF ARWQRQWRQWr",
                "1234",
                "www.www.www",
                "12345"
            )
        )
        schools.add(
            SchoolsItem(
                "12343",
                "Long BEach",
                "1234",
                "23rd Street",
                "1",
                "2",
                "asdadfac qweqwe",
                "2344",
                "2312 21",
                "12312@123123",
                "qweqdcsfd ASDASRRWC asd",
                "1234",
                "www.www.www",
                "12345"
            )
        )
        schools.add(
            SchoolsItem(
                "12346",
                "Long BEach",
                "1234",
                "23rd Street",
                "1",
                "2",
                "asdadfac qweqwe",
                "2344",
                "2312 21",
                "12312@123123",
                "ASD JHKLHJKJTY BBWER",
                "1234",
                "www.www.www",
                "12345"
            )
        )
        notifyDataSetChanged()
        DebugHelper.LogKitty("Adapter List > " + (schools.size))
    }

}