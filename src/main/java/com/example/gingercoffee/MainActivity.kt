package com.example.gingercoffee

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.gingercoffee.data.ViewPagerAdapter
import com.example.gingercoffee.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val FragmentsList = listOf(
            AvialiableDrinksFragment.newInstance(),
            PurchasedDrinksFragment.newInstance()
        )
    private val tabList = listOf(
        "Drinks", "Purchased"
    )
    val adapter = ViewPagerAdapter(this, FragmentsList)


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            ivMenu.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
            }
            viewPager.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
                tab.text = tabList[pos]
            }.attach()
            //openFrag(AvialiableDrinksFragment(),R.id.place_holder)

        }
    }
    

    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager.beginTransaction().replace(idHolder, f).commit()

    }

    }



