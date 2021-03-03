package com.example.shift2021.presentation.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shift2021.R
import com.example.shift2021.domain.CityWeather
import com.example.shift2021.CityWeatherApplication
import com.example.shift2021.presentation.details.DetailsActivity

class ListActivity : AppCompatActivity(), ListView {

    private val presenter by lazy {
        ListPresenterFactory.getPresenter()
    }

    private lateinit var cityList: RecyclerView
    private val adapter = CityAdapter {
        presenter.onCityClicked(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        cityList = findViewById(R.id.cityList)
        cityList.adapter = adapter
        cityList.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onViewResumed()
    }

    override fun bindCityList(list: List<CityWeather>) {
        adapter.cities = list
    }

    override fun openDetailsScreen(personId: Long) {
        DetailsActivity.start(this, personId)
    }
}
