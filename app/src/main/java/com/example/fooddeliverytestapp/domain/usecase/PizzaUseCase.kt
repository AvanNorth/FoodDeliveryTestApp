package com.example.fooddeliverytestapp.domain.usecase

import com.example.fooddeliverytestapp.domain.entity.CardMenuDataClass
import com.example.fooddeliverytestapp.domain.repository.PizzaRepository
import javax.inject.Inject

class PizzaUseCase @Inject constructor(
    private val pizzaRepository: PizzaRepository
) {
    suspend fun getPizzaList(): MutableList<CardMenuDataClass> = pizzaRepository.getPizzaFromApi()
}