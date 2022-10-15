package com.example.fooddeliverytestapp.data.api

import com.example.fooddeliverytestapp.R
import com.example.fooddeliverytestapp.domain.entity.CardMenuDataClass

class PizzaApi {
    private var pizzaList = mutableListOf<CardMenuDataClass>()
    private val nameArray = arrayOf("Ветчина и грибы", "Маргарита", "Четыре сезона", "Цыпленок барбекю")
    private val descrArray = arrayOf(
        "Ветчина, шампиньоны, увеличинная порция моцареллы, томатный соус",
        "Увеличенная порция моцареллы, томаты, итальянские травы, фирменный томатный соус",
        "Увеличенная порция моцареллы, ветчина, пикантная пепперони, кубики брынзы, томаты, шампиньоны, итальянские травы, фирменный томатный соус",
        "Цыпленок, бекон, соус барбекю, красный лук, моцарелла, фирменный томатный соус"
    )
    private val priceArray = arrayOf(429, 419, 539, 449)
    private val imageArray = arrayOf(R.drawable.ham_mushroom, R.drawable.margo, R.drawable.four_season, R.drawable.small_chiken_b)

    fun getPizzaList(): MutableList<CardMenuDataClass> {
        for(i in 0..3)
        pizzaList.add(CardMenuDataClass(nameArray[i], descrArray[i], priceArray[i], imageArray[i]))

        return pizzaList
    }
}