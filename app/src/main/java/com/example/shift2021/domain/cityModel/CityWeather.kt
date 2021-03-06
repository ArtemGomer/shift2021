package com.example.shift2021.domain.cityModel


data class CityWeather (
        val id: Long,
        val name: String,
        val main: Main,
        val sys: Sys,
        val weather: List<Weather>
        )