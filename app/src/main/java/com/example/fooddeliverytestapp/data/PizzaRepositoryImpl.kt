package com.example.fooddeliverytestapp.data

import com.example.fooddeliverytestapp.data.api.PizzaApi
import com.example.fooddeliverytestapp.domain.entity.CardMenuDataClass
import com.example.fooddeliverytestapp.domain.repository.PizzaRepository
import javax.inject.Inject

class PizzaRepositoryImpl @Inject constructor(
    private val api: PizzaApi
) : PizzaRepository {
    override suspend fun getPizzaFromApi(): MutableList<CardMenuDataClass> = api.getPizzaList()
}