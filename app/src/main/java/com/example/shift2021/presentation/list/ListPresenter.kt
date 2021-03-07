package com.example.shift2021.presentation.list

import androidx.lifecycle.MutableLiveData
import com.example.shift2021.domain.cityModel.CityWeather
import com.example.shift2021.domain.GetCitiesUseCase
import com.example.shift2021.presentation.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListPresenter(private val getCitiesUseCase: GetCitiesUseCase) : BasePresenter<ListView>() {

    val loading = MutableLiveData<Boolean>()

    fun onViewResumed() {
        loading.value = true
        getCitiesUseCase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate {
                    loading.value = false
                }
                .subscribe({
                    view?.bindCityList(it.list)
                }, {})
                .untilDestroy()
    }

    fun onCityClicked(city: CityWeather) {
        view?.openDetailsScreen(city.name)
    }

    fun findCity(name: String) {
        view?.openDetailsScreen(name)
    }

}