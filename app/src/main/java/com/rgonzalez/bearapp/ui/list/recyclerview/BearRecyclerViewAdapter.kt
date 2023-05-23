package com.rgonzalez.bearapp.ui.list.recyclerview

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rgonzalez.bearapp.data.bears
import com.rgonzalez.bearapp.data.model.BearModel
import com.rgonzalez.bearapp.databinding.BearItemBinding

class BearRecyclerViewAdapter(private val clickListener: (BearModel) -> Unit) :
    RecyclerView.Adapter<BearRecyclerViewHolder>() {

    private val bears = ArrayList<BearModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BearRecyclerViewHolder {
        val binding = BearItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  BearRecyclerViewHolder(binding, parent.context)
    }

    override fun getItemCount(): Int {
        return bears.size
    }

    override fun onBindViewHolder(holder: BearRecyclerViewHolder, position: Int) {
        val bear = bears[position]
        holder.bind(bear, clickListener)
    }

    fun setData(bearsList: List<BearModel>) {
        bears.clear()
        bears.addAll(bearsList)
        notifyDataSetChanged() // TODO Forzar update visual ?
    }



}