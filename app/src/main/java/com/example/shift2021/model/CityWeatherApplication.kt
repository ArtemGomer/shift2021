package com.example.shift2021.model

import android.app.Application

class CityWeatherApplication: Application() {
    val cityRepository = CityRepository()
}