package com.rgonzalez.bearapp.ui.form

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
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
        return binding.root
    }


}