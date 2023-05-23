package com.rgonzalez.bearapp.ui.form

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.rgonzalez.bearapp.R
import com.rgonzalez.bearapp.databinding.FragmentBearBinding
import com.rgonzalez.bearapp.databinding.FragmentNewBearBinding

class NewBearFragment : Fragment() {

    private val newBearViewModel: NewBearViewModel by activityViewModels {
        NewBearViewModel.Factory
    }

    private lateinit var binding: FragmentNewBearBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewBearBinding.inflate(inflater, container, false)
        val items = listOf("black", "white", "brown", "gray", "yellow")
        val adapter = ArrayAdapter(this.requireContext(), R.layout.item_list_colors, items )
        binding.ageList.setAdapter(adapter)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun observeStatus() {
        newBearViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(NewBearViewModel.WRONG_DATA) -> {
                    Log.d("TAG", status)
                    newBearViewModel.clearStatus()
                }
                status.equals(NewBearViewModel.BEAR_CREATED) -> {
                    Log.d("TAG", status)
                    newBearViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }
    fun setViewModel() {
        binding.viewmodel = newBearViewModel
    }


}