package com.example.shift2021.domain

import com.example.shift2021.domain.CityWeather

interface CityRepository {
    fun getCityById(id: Long): CityWeather?

    fun getCities(): List<CityWeather>
}