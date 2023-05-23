package com.rgonzalez.bearapp

import android.app.Application
import com.rgonzalez.bearapp.data.bears
import com.rgonzalez.bearapp.repositories.BearRepository

class BearReviewerApplication:Application() {
    val bearRepository: BearRepository by lazy {
        BearRepository(bears)
    }
}