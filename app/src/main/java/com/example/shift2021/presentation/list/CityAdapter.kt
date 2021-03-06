package com.example.shift2021.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shift2021.R
import com.example.shift2021.domain.cityModel.CityWeather
import com.squareup.picasso.Picasso

class CityAdapter(private val onClick: (CityWeather) -> Unit) : RecyclerView.Adapter<CityHolder>() {

    var cities: List<CityWeather> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return CityHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        val person = cities[position]
        holder.bind(person)
    }

    override fun getItemCount(): Int = cities.count()
}

class CityHolder(itemView: View, private val onClick: (CityWeather) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private val cityText: TextView = itemView.findViewById(R.id.cityText)
    private val temperatureText: TextView = itemView.findViewById(R.id.temperatureText)
    private val condImage : ImageView = itemView.findViewById(R.id.condPng)

    fun bind(city: CityWeather) {
        cityText.text = city.name
        temperatureText.text =itemView.context.getString(R.string.temperature_format, (city.main.temp - 273).toInt().toString())
        val url = "http://openweathermap.org/img/wn/${city.weather[0].icon}@2x.png"
        Picasso.with(itemView.context).load(url).resize(128, 128).into(condImage)
        itemView.setOnClickListener { onClick(city) }
    }
}