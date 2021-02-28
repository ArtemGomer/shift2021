package com.example.shift2021

import android.app.Application

class CityWeatherApplication: Application() {
    val cityRepository = CityRepository()
}