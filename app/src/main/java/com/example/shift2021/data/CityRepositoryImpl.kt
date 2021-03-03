package com.example.shift2021.data

import com.example.shift2021.domain.CityRepository
import com.example.shift2021.domain.CityWeather

class CityRepositoryImpl(private val cityDataSource: CityDataSource): CityRepository {
    override fun getCityById(id: Long): CityWeather? =
        cityDataSource.getCityById(id)


    override fun getCities(): List<CityWeather> =
            cityDataSource.getCities()
}