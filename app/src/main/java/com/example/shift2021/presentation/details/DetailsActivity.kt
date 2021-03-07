package com.example.shift2021.presentation.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isVisible
import com.example.shift2021.R
import com.example.shift2021.databinding.ActivityDetailsBinding
import com.example.shift2021.domain.cityModel.CityWeather
import com.squareup.picasso.Picasso

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

    private lateinit var activityDetailsBinding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailsBinding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(activityDetailsBinding.root)

        presenter.loading.observe(this) {
            activityDetailsBinding.content.isVisible = !it
            activityDetailsBinding.progressCircular.isVisible = it
        }
        presenter.attachView(this)
    }

    override fun bindCity(city: CityWeather) {
        activityDetailsBinding.cityNameText.text = city.name
        activityDetailsBinding.cityTemperatureText.text =
            getString(R.string.temperature_format, (city.main.temp - 273).toInt().toString())
        activityDetailsBinding.cityCountryText.text = city.sys.country
        activityDetailsBinding.cityPrecipitationText.text =
            getString(R.string.precipitation_format, city.weather[0].description)
        val url = "http://openweathermap.org/img/wn/${city.weather[0].icon}@2x.png"
        Picasso.with(this).load(url).resize(128, 128).into(activityDetailsBinding.weatherPng)
        activityDetailsBinding.backButton.setOnClickListener {
            presenter.getBack()
        }
    }

    override fun closeScreen() {
        finish()
    }
}