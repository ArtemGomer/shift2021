package com.example.shift2021.data

import com.example.shift2021.domain.cityModel.CityWeather
import com.example.shift2021.domain.cityModel.HTTPResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApi {
    @GET("find")
    fun getCitiesList(@Query("lat") lat: Int = 55,
                      @Query("lon") lon: Int = 83,
                      @Query("cnt") cnt: Int = 20,
                      @Query("appid") appid: String = "8690c561fbde90f53ac2fe5b7bf7dd6f"
    ): Single<HTTPResponse>

    @GET("weather")
    fun getCity(@Query("q") name: String,
                @Query("appid") appid: String = "8690c561fbde90f53ac2fe5b7bf7dd6f"
    ): Single<CityWeather>
}