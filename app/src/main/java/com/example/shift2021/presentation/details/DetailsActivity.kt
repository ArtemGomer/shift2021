package com.example.shift2021.presentation.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.shift2021.R
import com.example.shift2021.domain.cityModel.CityWeather

class DetailsActivity : AppCompatActivity(), DetailsView {

    companion object {

        private const val EXTRA_NAME = "EXTRA_NAME"

        fun start(context: Context, name: String) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(EXTRA_NAME, name)
            context.startActivity(intent)
        }
    }

    private val presenter by lazy {
        DetailsPresenterFactory.getPresenter(intent.getStringExtra(EXTRA_NAME) ?: "Unknown")
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
        temperatureText.text = getString(R.string.temperature_format, city.main.temp.toString())
        countryText.text = city.sys.country
        precipitationText.text = getString(R.string.precipitation_format, city.weather[0].description)
        backButton.setOnClickListener {
            presenter.getBack()
        }
    }

    override fun closeScreen() {
        finish()
    }
}