package com.rgonzalez.bearapp.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.rgonzalez.bearapp.R
import com.rgonzalez.bearapp.databinding.FragmentBearsBinding

class BearsFragment : Fragment() {
    private val bearsViewModel: BearsViewModel by activityViewModels {
        BearsViewModel.Factory
    }

    private lateinit var binding: FragmentBearsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBearsBinding.inflate(inflater, container, false)
        return binding.root
    }



}