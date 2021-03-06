package com.example.shift2021.presentation.details

import com.example.shift2021.domain.GetCityUseCase
import com.example.shift2021.presentation.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsPresenter(
        private val getCityUseCase: GetCityUseCase,
        private val cityName: String
        ): BasePresenter<DetailsView>() {

    override fun onViewAttached() {
        getCityUseCase(cityName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.bindCity(it)
                }, {
                    it.printStackTrace()
                    view?.closeScreen()
                })
                .untilDestroy()
    }

    fun getBack() {
        view?.closeScreen()
    }
}