package com.example.gingercoffee.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.gingercoffee.R
import com.example.gingercoffee.databinding.ItemDrinkBinding

class DrinkAdapter(val listener: Listener) : RecyclerView.Adapter<DrinkAdapter.DrinkHolder>() {
    val drinkList = ArrayList<Drink>()

    class DrinkHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemDrinkBinding.bind(item)
        private var isClickable = true


        fun bind(drink: Drink, listener: Listener) {
            with(binding) {

                tvTitle.text = drink.title
                tvPrice.text = drink.price.toString()

                    itemView.setOnClickListener {
                        if (isClickable) {
                            isClickable = false
                            val animation = AnimationUtils.loadAnimation(itemView.context, R.anim.recycler_anim)
                            itemView.startAnimation(animation)

                            itemView.postDelayed({
                                listener.onClick(drink)
                                isClickable = true
                            }, 200)
                        }
                    }
                }
            }
        }



                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkHolder {
                    val view =
                        LayoutInflater.from(parent.context)
                            .inflate(R.layout.item_drink, parent, false)
                    return DrinkHolder(view)
                }


                override fun onBindViewHolder(holder: DrinkHolder, position: Int) {
                    holder.bind(drinkList[position], listener)
                }


                override fun getItemCount(): Int {
                    return drinkList.size
                }

                fun addDrink(drink: Drink) {
                    drinkList.add(drink)
                    notifyDataSetChanged()
                }

                interface Listener {
                    fun onClick(drink: Drink)
                }


                fun removeDrink(drink: Drink) {
                    drinkList.remove(drink)
                    notifyDataSetChanged()
                }
            }


