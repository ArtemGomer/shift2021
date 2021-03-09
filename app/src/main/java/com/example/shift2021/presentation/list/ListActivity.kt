package com.example.shift2021.presentation.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shift2021.R
import com.example.shift2021.databinding.ActivityMainBinding
import com.example.shift2021.domain.cityModel.CityWeather
import com.example.shift2021.presentation.details.DetailsActivity

class ListActivity : AppCompatActivity(), ListView {

    private val presenter by lazy {
        ListPresenterFactory.getPresenter()
    }

    private lateinit var activityMainBinding: ActivityMainBinding
    private val adapter = CityAdapter {
        presenter.onCityClicked(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        presenter.attachView(this)
        initViews()
    }

    private fun initViews() {
        activityMainBinding.cityList.adapter = adapter
        activityMainBinding.cityList.layoutManager = LinearLayoutManager(this)
        activityMainBinding.findButton.setOnClickListener {
            presenter.findCity(activityMainBinding.findCityEditText.text.toString())
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onViewResumed()
    }

    override fun bindCityList(list: List<CityWeather>) {
        adapter.cities = list
    }

    override fun openDetailsScreen(name: String) {
        DetailsActivity.start(this, name)
    }

    override fun setIsLoading(loading: Boolean) {
        activityMainBinding.cityList.isVisible = !loading
        activityMainBinding.progressCircularList.isVisible = loading
    }


}
