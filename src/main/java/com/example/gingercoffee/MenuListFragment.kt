package com.example.gingercoffee

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.viewpager.widget.ViewPager
import com.example.gingercoffee.data.ViewPagerAdapter
import com.example.gingercoffee.databinding.FragmentMenuListBinding
import com.google.android.material.tabs.TabLayoutMediator


class MenuListFragment : Fragment() {
    private val FragmentsList: List<Fragment> = listOf(
        AvialiableDrinksFragment.newInstance(),
        PurchasedDrinksFragment.newInstance()
    )
    private val tabList = listOf(
        "Drinks", "Purchased"
    )
    lateinit var adapter: ViewPagerAdapter
    private lateinit var binding: FragmentMenuListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            adapter  = ViewPagerAdapter(activity as AppCompatActivity, FragmentsList)
            viewPager.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
                tab.text = tabList[pos]
                Log.v("MyLog","ViewPager was started")
            }.attach()


            //openFrag(AvialiableDrinksFragment(),R.id.place_holder)

        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            MenuListFragment()
    }
}