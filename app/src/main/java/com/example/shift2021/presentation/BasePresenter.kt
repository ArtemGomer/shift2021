package com.example.shift2021.presentation

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<T : BaseView> {
    var view: T? = null;
    private val compositeDisposable = CompositeDisposable()

    fun attachView(view: T) {
        this.view = view
        onViewAttached()
    }

    fun Disposable.untilDestroy() = compositeDisposable.add(this)

    open fun onViewAttached() {}

    fun destroy() {
        compositeDisposable.clear()
        this.view = null
    }
}