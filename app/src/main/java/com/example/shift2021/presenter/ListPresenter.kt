package com.example.shift2021.presenter

import com.example.shift2021.model.CityRepository
import com.example.shift2021.model.CityWeather
import com.example.shift2021.view.list.ListView

class ListPresenter(private val cityRepository: CityRepository): BasePresenter<ListView>() {

    fun onViewResumed() {
        val cityList = cityRepository.getCities()
        view?.bindCityList(cityList)
    }

    fun onCityClicked(city: CityWeather) {
        view?.openDetailsScreen(city.id)
    }

}