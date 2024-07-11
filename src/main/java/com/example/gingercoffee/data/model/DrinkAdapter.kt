package com.example.gingercoffee.data.model

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gingercoffee.data.Drink
import com.example.gingercoffee.databinding.ItemDrinkBinding

class DrinkAdapter: RecyclerView.Adapter<DrinkAdapter.DrinkHolder>() {
    val drinkList = ArrayList<Drink>()
    class DrinkHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = ItemDrinkBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: DrinkHolder, position: Int) {
        TODO("Not yet implemented")
    }
}