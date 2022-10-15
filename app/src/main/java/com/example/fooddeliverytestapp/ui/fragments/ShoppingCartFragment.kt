package com.example.fooddeliverytestapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fooddeliverytestapp.databinding.FragmentShoppingCartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShoppingCartFragment: Fragment() {
    private lateinit var binding: FragmentShoppingCartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoppingCartBinding.inflate(inflater, container, false)

        return binding.root
    }
}