package com.example.shift2021.presentation.list

import com.example.shift2021.domain.cityModel.CityWeather
import com.example.shift2021.presentation.BaseView

interface ListView: BaseView {
    fun bindCityList(list: List<CityWeather>)

    fun openDetailsScreen(name: String)

    fun setIsLoading(loading: Boolean)
}