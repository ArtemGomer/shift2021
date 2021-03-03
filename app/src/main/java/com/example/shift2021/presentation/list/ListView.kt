package com.example.shift2021.presentation.list

import com.example.shift2021.domain.CityWeather
import com.example.shift2021.presentation.BaseView

interface ListView: BaseView {
    fun bindCityList(list: List<CityWeather>)

    fun openDetailsScreen(personId: Long)
}