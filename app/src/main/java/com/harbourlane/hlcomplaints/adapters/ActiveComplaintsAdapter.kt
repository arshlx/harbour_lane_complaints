package com.harbourlane.hlcomplaints.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harbourlane.hlcomplaints.databinding.ItemActiveComplaintBinding
import com.harbourlane.hlcomplaints.model.ActiveComplaint

class ActiveComplaintsAdapter(private val activeComplaints: MutableList<ActiveComplaint>) :
    RecyclerView.Adapter<ActiveComplaintsAdapter.ActiveComplaintsViewHolder>() {
    inner class ActiveComplaintsViewHolder(private val binding: ItemActiveComplaintBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(complaint: ActiveComplaint) {
            binding.apply {
                txtInvoice.text = complaint.invoiceNumber
                txtName.text = complaint.customerName
                txtComplaintNumber.text = complaint.complaintNumber
                txtComplaintDescription.text = complaint.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveComplaintsViewHolder {
        return ActiveComplaintsViewHolder(
            ItemActiveComplaintBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = activeComplaints.size

    override fun onBindViewHolder(holder: ActiveComplaintsViewHolder, position: Int) {
        holder.bind(activeComplaints[position])
    }
}