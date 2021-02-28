package com.example.shift2021.cityStuff

class CityRepository {
    private val cities = mutableListOf(
            CityWeather(0, "Moscow", "Russia", "-10", "sunny"),
            CityWeather(0, "Berlin", "Germany", "0", "cloudy"),
            CityWeather(0, "Paris", "France", "-3", "snowy"),
            CityWeather(0, "London", "United Kingdom", "+4", "rainy"),
            CityWeather(0, "Kiev", "Ukraine", "-15", "snowy"),
            CityWeather(0, "Minsk", "Belarus", "-7", "sunny")
    )

    fun getCityById(id: Long): CityWeather? = cities.firstOrNull { it.id == id }

    fun getCities(): List<CityWeather> = cities
}