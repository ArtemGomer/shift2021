package com.example.shift2021.domain

class GetCityUseCase(private val cityRepository: CityRepository) {
    operator fun invoke(name: String) = cityRepository.getCity(name)
}