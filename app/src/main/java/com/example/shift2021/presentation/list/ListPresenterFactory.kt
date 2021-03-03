package com.example.shift2021.presentation.list

import com.example.shift2021.data.CityLocalDataSource
import com.example.shift2021.data.CityRepositoryImpl
import com.example.shift2021.domain.GetCitiesUseCase
import com.example.shift2021.domain.GetCityUseCase
import com.example.shift2021.presentation.details.DetailsPresenter

object ListPresenterFactory {
    fun getPresenter(): ListPresenter {
        val cityDataSource = CityLocalDataSource()
        val cityRepositoryImpl = CityRepositoryImpl(cityDataSource)
        val getCitiesUseCase = GetCitiesUseCase(cityRepositoryImpl)
        return ListPresenter(getCitiesUseCase)
    }
}