package com.example.fooddeliverytestapp.di

import com.example.fooddeliverytestapp.data.PizzaRepositoryImpl
import com.example.fooddeliverytestapp.domain.repository.PizzaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providePizzaRepository(pizzaRepositoryImpl: PizzaRepositoryImpl): PizzaRepository
}
