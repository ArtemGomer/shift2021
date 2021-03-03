package com.example.shift2021.presentation.details

import com.example.shift2021.domain.CityWeather
import com.example.shift2021.presentation.BaseView

interface DetailsView: BaseView {
    fun bindCity(city: CityWeather)

    fun closeScreen()
}