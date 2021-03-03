package com.example.shift2021.data

import com.example.shift2021.domain.CityWeather

interface CityDataSource {

    fun getCityById(id: Long): CityWeather?
    fun getCities(): List<CityWeather>
}