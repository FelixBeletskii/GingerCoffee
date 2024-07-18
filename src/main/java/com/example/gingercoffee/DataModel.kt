package com.example.gingercoffee

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gingercoffee.data.Drink

class DataModel: ViewModel() {
    val selectedDrink : MutableLiveData<Drink> by lazy {
        MutableLiveData<Drink>()
    }
    val deletedDrink: MutableLiveData<Drink> by lazy {
        MutableLiveData<Drink>()
    }
}