package com.example.shift2021.presenter

import com.example.shift2021.model.CityRepository
import com.example.shift2021.view.details.DetailsView

class DetailsPresenter(
        private val cityRepository: CityRepository,
        private val cityId: Long
        ): BasePresenter<DetailsView>() {

    override fun onViewAttached() {
        val city = cityRepository.getCityById(cityId)
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