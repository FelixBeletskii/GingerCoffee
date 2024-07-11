package com.example.gingercoffee

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gingercoffee.data.Drink
import com.example.gingercoffee.data.model.DrinkAdapter
import com.example.gingercoffee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter = DrinkAdapter()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            ivMenu.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
            }
        }
        init()
    }

    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager.beginTransaction().replace(idHolder, f).commit()

    }

    fun init() {
        val drinksList: Array<String> = resources.getStringArray(R.array.Drinks)
        val priceList : IntArray = resources.getIntArray(R.array.price)

        binding.apply {
            recycler.layoutManager = LinearLayoutManager(this@MainActivity)
            recycler.adapter = adapter
            for (i in 0 until drinksList.size) {
                val drink = Drink(drinksList[i], priceList[i])
                adapter.addDrink(drink)
            }

        }
    }
}