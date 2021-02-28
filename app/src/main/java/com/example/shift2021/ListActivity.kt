package com.example.shift2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shift2021.cityAdapter.CityAdapter
import com.example.shift2021.cityStuff.CityRepository
import com.example.shift2021.cityStuff.CityWeatherApplication

class ListActivity : AppCompatActivity() {

    private lateinit var cityRepository: CityRepository
    private lateinit var cityList: RecyclerView
    private val adapter = CityAdapter {
        DetailsActivity.start(this, it.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cityList = findViewById(R.id.cityList)
        cityRepository = (application as CityWeatherApplication).cityRepository
        cityList.adapter = adapter
        cityList.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        adapter.cities = cityRepository.getCities()
    }
}
