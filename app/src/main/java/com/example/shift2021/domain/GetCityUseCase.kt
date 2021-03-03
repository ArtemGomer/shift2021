package com.example.shift2021.domain

class GetCityUseCase(private val cityRepository: CityRepository) {
    operator fun invoke(id: Long) = cityRepository.getCityById(id)
}