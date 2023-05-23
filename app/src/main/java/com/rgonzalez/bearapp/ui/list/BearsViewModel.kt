package com.rgonzalez.bearapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.rgonzalez.bearapp.BearReviewerApplication
import com.rgonzalez.bearapp.R
import com.rgonzalez.bearapp.data.model.BearModel
import com.rgonzalez.bearapp.repositories.BearRepository

class BearsViewModel(private val repository: BearRepository) : ViewModel() {
    private val bearModelLiveData = MutableLiveData<BearModel>()

    fun getBears() = repository.getBears()

    fun setBear(bearModel: BearModel) {
        bearModelLiveData.value = bearModel
    }
    fun setBearModel(bearModel: BearModel) {
        bearModelLiveData.value = bearModel
    }

    fun getBear(): LiveData<BearModel> {
        return bearModelLiveData
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BearReviewerApplication
                BearsViewModel(app.bearRepository)
            }
        }
    }
}