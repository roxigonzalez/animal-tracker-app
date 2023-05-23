package com.rgonzalez.bearapp.ui.list.recyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.rgonzalez.bearapp.data.model.BearModel
import com.rgonzalez.bearapp.databinding.BearItemBinding


class BearRecyclerViewHolder(private val binding: BearItemBinding, private val context: Context):RecyclerView.ViewHolder(binding.root) {

    fun bind(bear: BearModel, clickListener: (BearModel) -> Unit) {
        binding.bearNameText.text = bear.name
        binding.bearColorText.text = bear.color

        binding.cardBearItem.setOnClickListener{
            clickListener(bear)
        }
    }
}