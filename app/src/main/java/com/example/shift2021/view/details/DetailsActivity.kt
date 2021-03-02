package com.example.shift2021.view.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.shift2021.R
import com.example.shift2021.model.CityWeather
import com.example.shift2021.model.CityWeatherApplication
import com.example.shift2021.presenter.DetailsPresenter

class DetailsActivity : AppCompatActivity(), DetailsView {

    companion object {

        private const val EXTRA_ID = "EXTRA_ID"

        fun start(context: Context, id: Long) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(EXTRA_ID, id)
            context.startActivity(intent)
        }
    }

    private val presenter by lazy {
        DetailsPresenter((application as CityWeatherApplication).cityRepository,
        intent.getLongExtra(EXTRA_ID, 0))
    }


    private lateinit var nameText: TextView
    private lateinit var temperatureText: TextView
    private lateinit var countryText: TextView
    private lateinit var precipitationText: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initViews()
        presenter.attachView(this)
    }

    private fun initViews() {
        nameText = findViewById(R.id.city_name_text)
        countryText = findViewById(R.id.city_country_text)
        temperatureText = findViewById(R.id.city_temperature_text)
        precipitationText = findViewById(R.id.city_precipitation_text)
        backButton = findViewById(R.id.back_button)
    }

    override fun bindCity(city: CityWeather) {
        nameText.text = city.name
        temperatureText.text = getString(R.string.temperature_format, city.temperature)
        countryText.text = city.country
        precipitationText.text = getString(R.string.precipitation_format, city.precipitation)
        backButton.setOnClickListener {
            presenter.getBack()
        }
    }

    override fun closeScreen() {
        finish()
    }
}