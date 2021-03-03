package com.example.shift2021.data

import com.example.shift2021.domain.CityWeather

class CityLocalDataSource: CityDataSource{
    override fun getCityById(id: Long) = cities.firstOrNull { it.id == id }

    override fun getCities(): List<CityWeather> = cities

    private val cities = mutableListOf(
            CityWeather(0, "Moscow", "Russia", "-10", "sunny"),
            CityWeather(1, "Berlin", "Germany", "0", "cloudy"),
            CityWeather(2, "Paris", "France", "-3", "snowy"),
            CityWeather(3, "London", "United Kingdom", "+4", "rainy"),
            CityWeather(4, "Kiev", "Ukraine", "-15", "snowy"),
            CityWeather(5, "Minsk", "Belarus", "-7", "sunny")
    )
}