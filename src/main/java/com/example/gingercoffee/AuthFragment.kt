package com.example.gingercoffee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gingercoffee.databinding.FragmentAuthBinding


class AuthFragment : Fragment() {
    lateinit var bind: FragmentAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentAuthBinding.inflate(inflater)
        return bind.root

        }
    }



