package com.viewmodeldemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel ( startingValue :Int ) : ViewModel() {
    private var total = MutableLiveData<Int>()
    val totalData : LiveData<Int>
    get() = total


    init {
        total.value = startingValue
    }

//    fun getTotal(): Int {
//        return total
//    }

    fun setTotal(input: Int) {
//        total += input
        total.value = (total.value)?.plus(input)
    }
}