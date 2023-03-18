package com.example.arlibtest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.arlibtest.data.Medication
import com.example.arlibtest.databinding.MedicationListItemBinding

class MedicationsListAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Medication, MedicationsListAdapter.MedicationViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): MedicationViewHolder {
        return MedicationViewHolder(
            MedicationListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: MedicationViewHolder, position: Int
    ) {
        val medication = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(medication)
        }
        holder.bind(medication)
    }

    class MedicationViewHolder(private var binding: MedicationListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(medication: Medication) {
            binding.medication = medication
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Medication>() {
        override fun areItemsTheSame(oldItem: Medication, newItem: Medication): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Medication, newItem: Medication): Boolean {
            return oldItem.name == newItem.name
        }
    }

    class OnClickListener(val clickListener: (medication: Medication) -> Unit) {
        fun onClick(medication: Medication) = clickListener(medication)
    }
}

