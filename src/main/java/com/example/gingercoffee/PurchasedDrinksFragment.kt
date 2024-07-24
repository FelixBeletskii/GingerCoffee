package com.example.gingercoffee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gingercoffee.data.Drink
import com.example.gingercoffee.data.DrinkAdapter
import com.example.gingercoffee.databinding.FragmentPurchasedDrinksBinding


class PurchasedDrinksFragment : Fragment(), DrinkAdapter.Listener {



    private val adapter = DrinkAdapter(this)
    private val model: DataModel by activityViewModels()
    var purchasedDrinks = mutableListOf<Drink>(

    )
    private lateinit var binding: FragmentPurchasedDrinksBinding


    fun init() {
        with(binding) {
            recyclerPurchased.layoutManager = LinearLayoutManager(activity as AppCompatActivity)
            recyclerPurchased.adapter = adapter

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPurchasedDrinksBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        model.selectedDrink.observe(activity as LifecycleOwner, {
            adapter.addDrink(it)
            purchasedDrinks.add(it)

        })

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            PurchasedDrinksFragment()
    }

    override fun onClick(drink: Drink) {
        adapter.removeDrink(drink)
    }



        }





