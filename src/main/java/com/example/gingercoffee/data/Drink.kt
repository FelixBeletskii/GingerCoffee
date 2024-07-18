package com.example.gingercoffee.data

import com.example.gingercoffee.R

data class Drink(val title: String, var price: Int = 0) {
    fun countDrink(title: String): Int{
       price =  when(title){
            "Cappucino" , "Latte"-> 150
            "Americano" -> 140
            "Raf" -> 190
           "Flat White" -> 180
           "Tea" -> 110


           else -> {0}
       }
        return price
    }
}