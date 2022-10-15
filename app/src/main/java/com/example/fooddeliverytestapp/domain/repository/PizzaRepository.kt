package com.example.fooddeliverytestapp.domain.repository

import com.example.fooddeliverytestapp.domain.entity.CardMenuDataClass

interface PizzaRepository {
    suspend fun getPizzaFromApi(): MutableList<CardMenuDataClass>
}