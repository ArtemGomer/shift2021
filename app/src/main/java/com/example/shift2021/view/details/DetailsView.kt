package com.example.shift2021.view.details

import com.example.shift2021.model.CityWeather
import com.example.shift2021.presenter.BaseView

interface DetailsView: BaseView {
    fun bindCity(city: CityWeather)

    fun closeScreen()
}