package com.example.shift2021.presentation.list

import com.example.shift2021.data.CityRemoteDataSource
import com.example.shift2021.data.CityRepositoryImpl
import com.example.shift2021.data.RetrofitHolder
import com.example.shift2021.domain.GetCitiesUseCase

object ListPresenterFactory {
    fun getPresenter(): ListPresenter {
        val cityDataSource = CityRemoteDataSource(RetrofitHolder.cityApi)
        val cityRepositoryImpl = CityRepositoryImpl(cityDataSource)
        val getCitiesUseCase = GetCitiesUseCase(cityRepositoryImpl)
        return ListPresenter(getCitiesUseCase)
    }
}