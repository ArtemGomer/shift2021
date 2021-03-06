package com.example.shift2021.data

import com.example.shift2021.domain.cityModel.CityWeather
import com.example.shift2021.domain.cityModel.HTTPResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class CityRemoteDataSource(private val api: CityApi): CityDataSource{
    override fun getCity(name: String): Single<CityWeather> =
            api.getCity(name)
                    .subscribeOn(Schedulers.io())

    override fun getCities(): Single<HTTPResponse> =
            api.getCitiesList()
                    .subscribeOn(Schedulers.io())

}