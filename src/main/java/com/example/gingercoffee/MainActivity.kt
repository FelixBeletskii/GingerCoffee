package com.example.gingercoffee

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.gingercoffee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        findNavController(R.id.nav_host_fragment)


        with(binding) {
            val controller = findNavController(R.id.nav_host_fragment)
            bottomNavigationView.selectedItemId = R.id.home
            bottomNavigationView.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> controller.navigate(R.id.homeFragment)

                    R.id.work -> controller.navigate(R.id.menuListFragment)
                    R.id.drinks -> controller.navigate(R.id.drinksFragment)


                    R.id.report -> controller.navigate(R.id.reportFragment)


                }
                true
            }

            actionBar.ivMenu.setOnClickListener {
                drawer.openDrawer(GravityCompat.START)
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val controller = findNavController(R.id.nav_host_fragment)
        return controller.navigateUp() || super.onSupportNavigateUp()
    }


    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager.beginTransaction().replace(idHolder, f).commit()

    }


}



