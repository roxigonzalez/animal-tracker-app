package com.rgonzalez.bearapp.ui.form

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rgonzalez.bearapp.BearReviewerApplication
import com.rgonzalez.bearapp.data.model.BearModel
import com.rgonzalez.bearapp.repositories.BearRepository

class NewBearViewModel(private val repository: BearRepository) : ViewModel() {
    var name = MutableLiveData("")
    var color = MutableLiveData("")
    var age = MutableLiveData("")
    var height = MutableLiveData("")
    var status = MutableLiveData("")


    fun addBear(bear: BearModel) = repository.addBear(bear)

    fun validateBear():Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            height.value.isNullOrEmpty() -> return false
            age.value.isNullOrEmpty() -> return false
            color.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createBear() {
        if(!validateBear()) {
            status.value = WRONG_DATA
            return
        }
        val bear = BearModel(
            name.value!!,
            color.value!!,
            age.value!!.toInt(),
            height.value!!.toDouble(),
        )
        addBear(bear)
        status.value = BEAR_CREATED
        clearData()

    }

    fun clearStatus() {
        status.value = INACTIVE
    }
    fun clearData() {
        name.value = ""
        color.value = ""
        age.value = ""
        height.value = ""
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BearReviewerApplication
                NewBearViewModel(app.bearRepository)
            }
        }

        const val BEAR_CREATED = "created"
        const val WRONG_DATA = "error, wrong data"
        const val INACTIVE = ""
    }

}