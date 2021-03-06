package com.example.shift2021.presentation.details

import com.example.shift2021.data.CityRemoteDataSource
import com.example.shift2021.data.CityRepositoryImpl
import com.example.shift2021.data.RetrofitHolder
import com.example.shift2021.domain.GetCityUseCase

object DetailsPresenterFactory {
    fun getPresenter(name: String): DetailsPresenter {
        val cityDataSource = CityRemoteDataSource(RetrofitHolder.cityApi)
        val cityRepositoryImpl = CityRepositoryImpl(cityDataSource)
        val getCityUseCase = GetCityUseCase(cityRepositoryImpl)
        return DetailsPresenter(getCityUseCase, name)
    }
}