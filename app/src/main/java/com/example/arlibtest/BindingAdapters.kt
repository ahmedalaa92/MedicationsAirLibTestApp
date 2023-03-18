package com.example.arlibtest

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.arlibtest.data.Medication
import com.example.arlibtest.ui.MedicationsListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Medication>?) {
    val adapter = recyclerView.adapter as? MedicationsListAdapter
    adapter?.submitList(data)
}