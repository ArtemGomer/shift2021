package com.example.shift2021.presentation.details

import com.example.shift2021.domain.CityRepository
import com.example.shift2021.domain.GetCityUseCase
import com.example.shift2021.presentation.BasePresenter

class DetailsPresenter(
        private val getCityUseCase: GetCityUseCase,
        private val cityId: Long
        ): BasePresenter<DetailsView>() {

    override fun onViewAttached() {
        val city = getCityUseCase(cityId)
        if (city != null) {
            view?.bindCity(city)
        } else {
            view?.closeScreen()
        }
    }

    fun getBack() {
        view?.closeScreen()
    }
}