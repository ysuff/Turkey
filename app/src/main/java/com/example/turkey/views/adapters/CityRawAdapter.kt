package com.example.turkey.views.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.turkey.R
import com.example.turkey.views.CityNameDirections

class CityRawAdapter(
    private val cityName: List<String>,
    private val cityImageView: List<Int>,
    private val cityVisit: List<String>,
    private val cityFood: List<String>
) : RecyclerView.Adapter<CityRawAdapter.CityNameList>() {

    private var filteredCityName = cityName.toMutableList()
    private var filteredCityImageView = cityImageView.toMutableList()
    private var filteredCityVisit = cityVisit.toMutableList()
    private var filteredCityFood = cityFood.toMutableList()

    class CityNameList(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityNameList {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.city_name_raw, parent, false)
        return CityNameList(itemView)
    }

    override fun getItemCount(): Int {
        return filteredCityName.size
    }

    override fun onBindViewHolder(holder: CityNameList, position: Int) {
        val cityNameTextView = holder.itemView.findViewById<TextView>(R.id.cityNameRawTextView)
        cityNameTextView.text = filteredCityName.getOrNull(position) ?: "Boş"

        holder.itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putString("cityName", filteredCityName.getOrNull(position) ?: "Boş")
                putString("cityVisit", filteredCityVisit.getOrNull(position) ?: "Boş")
                putString("cityFood", filteredCityFood.getOrNull(position) ?: "Boş")
                putString("cityImage", filteredCityImageView.getOrNull(position)?.toString() ?: "Boş")
            }

            val action = CityNameDirections.actionCityNameToCityDetail()
            Navigation.findNavController(it).navigate(action.actionId, bundle)
        }
    }

    fun filter(query: String) {
        if (query.isEmpty()) {
            filteredCityName = cityName.toMutableList()
            filteredCityImageView = cityImageView.toMutableList()
            filteredCityVisit = cityVisit.toMutableList()
            filteredCityFood = cityFood.toMutableList()
        } else {
            val lowercaseQuery = query.lowercase()
            filteredCityName = cityName.filter { it.lowercase().contains(lowercaseQuery) }.toMutableList()
            filteredCityImageView = cityImageView.filterIndexed { index, _ ->
                cityName[index].lowercase().contains(lowercaseQuery)
            }.toMutableList()
            filteredCityVisit = cityVisit.filterIndexed { index, _ ->
                cityName[index].lowercase().contains(lowercaseQuery)
            }.toMutableList()
            filteredCityFood = cityFood.filterIndexed { index, _ ->
                cityName[index].lowercase().contains(lowercaseQuery)
            }.toMutableList()
        }
        notifyDataSetChanged()
    }
}
