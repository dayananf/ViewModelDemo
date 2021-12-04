package com.viewmodeldemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MainViewModelFactory (private var startingValue :Int ) :ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel(startingValue) as T

        }
        throw IllegalArgumentException("Unknow ViewModel Call")

    }
}