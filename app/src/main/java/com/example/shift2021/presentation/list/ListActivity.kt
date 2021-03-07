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
import com.example.shift2021.domain.cityModel.CityWeather
import com.example.shift2021.presentation.details.DetailsActivity

class ListActivity : AppCompatActivity(), ListView {

    private val presenter by lazy {
        ListPresenterFactory.getPresenter()
    }

    private lateinit var cityList: RecyclerView
    private lateinit var findButton: Button
    private lateinit var findCityEditText: EditText
    private lateinit var progressBar: ProgressBar
    private val adapter = CityAdapter {
        presenter.onCityClicked(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        initViews()
        presenter.loading.observe(this) {
            cityList.isVisible = !it
            progressBar.isVisible = it
        }
    }

    private fun initViews() {
        cityList = findViewById(R.id.cityList)
        findButton = findViewById(R.id.findButton)
        findCityEditText = findViewById(R.id.findCityEditText)
        progressBar = findViewById(R.id.progress_circular_list)
        cityList.adapter = adapter
        cityList.layoutManager = LinearLayoutManager(this)
        findButton.setOnClickListener {
            presenter.findCity(findCityEditText.text.toString())
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
}
