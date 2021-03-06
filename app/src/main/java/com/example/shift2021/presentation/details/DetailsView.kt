package com.example.shift2021.presentation.details

import com.example.shift2021.domain.cityModel.CityWeather
import com.example.shift2021.presentation.BaseView

interface DetailsView: BaseView {
    fun bindCity(city: CityWeather)

    fun closeScreen()
}