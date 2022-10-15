package com.example.fooddeliverytestapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddeliverytestapp.domain.entity.CardMenuDataClass
import com.example.fooddeliverytestapp.domain.usecase.PizzaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val pizzaUseCase: PizzaUseCase
) : ViewModel() {

    private var _pizzaList: MutableLiveData<Result<MutableList<CardMenuDataClass>>> = MutableLiveData()
    val pizzaList: LiveData<Result<MutableList<CardMenuDataClass>>> = _pizzaList

    fun getPizza() = viewModelScope.launch {
        try {
            _pizzaList.value = Result.success(pizzaUseCase.getPizzaList())
        } catch (e: Exception) {
            _pizzaList.value = Result.failure(e)
        }
    }
}
