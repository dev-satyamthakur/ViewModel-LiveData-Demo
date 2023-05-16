package com.satyamthakur.livedataviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var number = 1

    val currentNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val currentBool: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

}