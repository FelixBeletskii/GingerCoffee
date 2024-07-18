package com.example.gingercoffee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gingercoffee.databinding.FragmentPurchasedDrinksBinding
import com.example.gingercoffee.databinding.ItemDrinkBinding


class PurchasedDrinksFragment : Fragment() {
        private lateinit var binding: FragmentPurchasedDrinksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPurchasedDrinksBinding.inflate(inflater)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            PurchasedDrinksFragment()
    }
}