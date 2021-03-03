package com.example.shift2021.domain

class GetCitiesUseCase(private val cityRepository: CityRepository) {
    operator fun invoke() = cityRepository.getCities()
}