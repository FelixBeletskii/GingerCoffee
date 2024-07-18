package com.example.gingercoffee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gingercoffee.data.Drink
import com.example.gingercoffee.data.model.DrinkAdapter
import com.example.gingercoffee.databinding.FragmentAvialiableDrinksBinding

class AvialiableDrinksFragment : Fragment(), DrinkAdapter.Listener {
    private val adapter = DrinkAdapter(this)


    lateinit var binding: FragmentAvialiableDrinksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAvialiableDrinksBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    fun init() {
        val drinksList: Array<String> = resources.getStringArray(R.array.Drinks)

        binding.apply {
            recycler.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
            recycler.adapter = adapter

            for (i in 0 until drinksList.size) {
                val drink = Drink(drinksList[i])
                drink.countDrink(drink.title)
                adapter.addDrink(drink)
            }

        }
    }


        override fun onClick(drink: Drink) {
            Toast.makeText(
                activity as AppCompatActivity,
                "Нажали на ${drink.title}",
                Toast.LENGTH_SHORT
            ).show()

        }

    companion object {

        @JvmStatic
        fun newInstance() =
            AvialiableDrinksFragment()
    }


    }

