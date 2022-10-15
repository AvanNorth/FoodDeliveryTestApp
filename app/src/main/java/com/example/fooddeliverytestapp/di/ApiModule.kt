package com.example.fooddeliverytestapp.di

import com.example.fooddeliverytestapp.data.api.PizzaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    @Singleton
    fun providePizzaApi(): PizzaApi = PizzaApi()
}