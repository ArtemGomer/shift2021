package com.example.shift2021.cityStuff

import android.app.Application

class CityWeatherApplication: Application() {
    val cityRepository = CityRepository()
}