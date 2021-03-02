package com.example.shift2021.view.list

import com.example.shift2021.model.CityWeather
import com.example.shift2021.presenter.BaseView

interface ListView: BaseView {
    fun bindCityList(list: List<CityWeather>)

    fun openDetailsScreen(personId: Long)
}