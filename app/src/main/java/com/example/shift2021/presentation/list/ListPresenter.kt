package com.example.shift2021.presentation.list

import com.example.shift2021.domain.CityRepository
import com.example.shift2021.domain.CityWeather
import com.example.shift2021.domain.GetCitiesUseCase
import com.example.shift2021.presentation.BasePresenter

class ListPresenter(private val getCitiesUseCase: GetCitiesUseCase): BasePresenter<ListView>() {

    fun onViewResumed() {
        val cityList = getCitiesUseCase()
        view?.bindCityList(cityList)
    }

    fun onCityClicked(city: CityWeather) {
        view?.openDetailsScreen(city.id)
    }

}