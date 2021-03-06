package com.example.shift2021.data

import com.example.shift2021.domain.CityRepository
import com.example.shift2021.domain.cityModel.CityWeather
import com.example.shift2021.domain.cityModel.HTTPResponse
import io.reactivex.Single

class CityRepositoryImpl(private val cityDataSource: CityDataSource): CityRepository {
    override fun getCity(name: String): Single<CityWeather> =
        cityDataSource.getCity(name)


    override fun getCities(): Single<HTTPResponse> =
            cityDataSource.getCities()
}