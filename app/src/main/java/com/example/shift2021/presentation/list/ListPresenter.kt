package com.example.shift2021.presentation.list

import com.example.shift2021.domain.cityModel.CityWeather
import com.example.shift2021.domain.GetCitiesUseCase
import com.example.shift2021.presentation.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListPresenter(private val getCitiesUseCase: GetCitiesUseCase) : BasePresenter<ListView>() {

    fun onViewResumed() {
        getCitiesUseCase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.bindCityList(it.list)
                }, {})
                .untilDestroy()
    }

    fun onCityClicked(city: CityWeather) {
        view?.openDetailsScreen(city.name)
    }

}