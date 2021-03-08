package com.example.shift2021.data

import com.example.shift2021.domain.cityModel.CityWeather
import com.example.shift2021.domain.cityModel.HTTPResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApi {

    companion object {
        const val KEY = "8690c561fbde90f53ac2fe5b7bf7dd6f"
    }

    @GET("find")
    fun getCitiesList(@Query("lat") lat: Int = 55,
                      @Query("lon") lon: Int = 83,
                      @Query("cnt") cnt: Int = 20,
                      @Query("appid") appid: String = KEY
    ): Single<HTTPResponse>

    @GET("weather")
    fun getCity(@Query("q") name: String,
                @Query("appid") appid: String = KEY
    ): Single<CityWeather>
}