package com.rgonzalez.bearapp.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rgonzalez.bearapp.R
import com.rgonzalez.bearapp.data.model.BearModel
import com.rgonzalez.bearapp.databinding.FragmentBearsBinding
import com.rgonzalez.bearapp.ui.list.recyclerview.BearRecyclerViewAdapter

class BearsFragment : Fragment() {
    private val bearsViewModel: BearsViewModel by activityViewModels {
        BearsViewModel.Factory
    }

    private lateinit var binding: FragmentBearsBinding
    private lateinit var recyclerViewAdapter: BearRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBearsBinding.inflate(inflater, container, false)
        return binding.root
    }
    private fun displayBears() {
        Log.d("TAG", bearsViewModel.getBears().toString())
        recyclerViewAdapter.setData(bearsViewModel.getBears())
        recyclerViewAdapter.notifyDataSetChanged()
    }

    fun showSelectedItem(bear: BearModel) {
        bearsViewModel.setBearModel(bear)
        findNavController().navigate(R.id.action_bearsFragment_to_bearFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerViewAdapter = BearRecyclerViewAdapter { selectedBear ->
            showSelectedItem(selectedBear)
        }
        binding.recyclerView.adapter = recyclerViewAdapter
        displayBears()

    }



}