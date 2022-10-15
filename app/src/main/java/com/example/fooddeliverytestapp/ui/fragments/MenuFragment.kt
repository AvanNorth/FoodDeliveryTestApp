package com.example.fooddeliverytestapp.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddeliverytestapp.data.adapter.MenuAdapter
import com.example.fooddeliverytestapp.databinding.FragmentMenuBinding
import com.example.fooddeliverytestapp.domain.entity.CardMenuDataClass
import com.example.fooddeliverytestapp.ui.viewmodel.MenuViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private val viewModel: MenuViewModel by viewModels()
    private lateinit var adapter: MenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MenuAdapter(requireContext()) { dataList, position ->
            AlertDialog.Builder(context)
                .setTitle("Добавить в корзину")
                .setMessage("Вы уверены что хотите добавить " +
                        dataList[position].title + " по цене " +
                        dataList[position].price + " в корзину?")
                .setPositiveButton(
                    "Да", null)
                .setNegativeButton("Нет", null)
                .show()
        }

        initObservers()
        viewModel.getPizza()
    }


    private fun initObservers() {
        viewModel.pizzaList.observe(viewLifecycleOwner) { result ->
            result.fold(
                onSuccess = { pizzaList ->
                    initPizzaData(pizzaList)
                },
                onFailure = { e ->
                    Timber.e(e.message.toString())
                }
            )
        }
    }

    private fun initPizzaData(list: MutableList<CardMenuDataClass>) {
        with(binding) {
            adapter.setDataList(list)
            pizzaRV.adapter = adapter
            pizzaRV.layoutManager = LinearLayoutManager(this@MenuFragment.requireContext())
        }
    }

}