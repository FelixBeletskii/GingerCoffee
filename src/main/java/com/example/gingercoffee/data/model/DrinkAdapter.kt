package com.example.gingercoffee.data.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gingercoffee.R
import com.example.gingercoffee.data.Drink
import com.example.gingercoffee.databinding.ItemDrinkBinding

class DrinkAdapter(val listener: Listener): RecyclerView.Adapter<DrinkAdapter.DrinkHolder>() {
    val drinkList = ArrayList<Drink>()

    class DrinkHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemDrinkBinding.bind(item)
        fun bind(drink: Drink, listener: Listener) {
            with(binding) {
                tvTitle.text = drink.title
                tvPrice.text = drink.price.toString()
          itemView.setOnClickListener {
              listener.onClick(drink) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_drink, parent, false)
        return DrinkHolder(view)
    }


    override fun onBindViewHolder(holder: DrinkHolder, position: Int) {
        holder.bind(drinkList[position], listener)
    }


    override fun getItemCount(): Int {
        return drinkList.size
    }

    fun addDrink(drink:Drink){
        drinkList.add(drink)
        notifyDataSetChanged()
    }

    interface Listener{
        fun onClick(drink:Drink)

    }
    fun removeDrink(drink: Drink){
        drinkList.remove(drink)
        notifyDataSetChanged()
    }

}