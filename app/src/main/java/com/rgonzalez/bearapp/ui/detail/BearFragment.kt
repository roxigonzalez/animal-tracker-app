package com.rgonzalez.bearapp.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.rgonzalez.bearapp.R
import com.rgonzalez.bearapp.databinding.FragmentBearBinding
import com.rgonzalez.bearapp.ui.list.BearsViewModel

class BearFragment : Fragment() {
    private val bearViewModel: BearViewModel by activityViewModels {
        BearViewModel.Factory
    }

    private lateinit var binding: FragmentBearBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBearBinding.inflate(inflater, container, false)
        return binding.root
    }


}