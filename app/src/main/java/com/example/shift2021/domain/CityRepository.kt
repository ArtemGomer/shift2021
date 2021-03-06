package com.example.shift2021.domain

import com.example.shift2021.domain.cityModel.CityWeather
import com.example.shift2021.domain.cityModel.HTTPResponse
import io.reactivex.Single

interface CityRepository {
    fun getCity(name: String): Single<CityWeather>

    fun getCities(): Single<HTTPResponse>
}