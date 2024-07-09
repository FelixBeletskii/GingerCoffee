package com.example.gingercoffee

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel: ViewModel() {
    val userData : MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }
}