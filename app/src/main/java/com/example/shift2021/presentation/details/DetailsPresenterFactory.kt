package com.example.shift2021.presentation.details

import com.example.shift2021.data.CityDataSource
import com.example.shift2021.data.CityLocalDataSource
import com.example.shift2021.data.CityRepositoryImpl
import com.example.shift2021.domain.GetCityUseCase

object DetailsPresenterFactory {
    fun getPresenter(id: Long): DetailsPresenter {
        val cityDataSource = CityLocalDataSource()
        val cityRepositoryImpl = CityRepositoryImpl(cityDataSource)
        val getCityUseCase = GetCityUseCase(cityRepositoryImpl)
        return DetailsPresenter(getCityUseCase, id)
    }
}