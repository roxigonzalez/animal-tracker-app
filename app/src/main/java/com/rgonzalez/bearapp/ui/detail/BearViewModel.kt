package com.rgonzalez.bearapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rgonzalez.bearapp.BearReviewerApplication
import com.rgonzalez.bearapp.data.model.BearModel
import com.rgonzalez.bearapp.repositories.BearRepository

class BearViewModel(private val repository: BearRepository): ViewModel() {
    private val bearModelLiveData = MutableLiveData<BearModel>()

    // declaring variables
    var name = MutableLiveData("")
    var age = MutableLiveData("")
    var color = MutableLiveData("")
    var height = MutableLiveData("")


    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BearReviewerApplication
                BearViewModel(app.bearRepository)
            }
        }
    }
}