package com.example.shift2021.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shift2021.R
import com.example.shift2021.domain.cityModel.CityWeather

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

    fun bind(city: CityWeather) {
        cityText.text = city.name
        temperatureText.text =itemView.context.getString(R.string.temperature_format, city.main.temp)
        itemView.setOnClickListener { onClick(city) }
    }
}