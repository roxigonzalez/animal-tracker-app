package com.rgonzalez.bearapp.repositories

import com.rgonzalez.bearapp.data.model.BearModel

class BearRepository(private val bears: MutableList<BearModel>) {

    // get all bears
    fun getBears() = bears

    // function to add new bear
    fun addBear(bear: BearModel) = bears.add(0, bear)
}