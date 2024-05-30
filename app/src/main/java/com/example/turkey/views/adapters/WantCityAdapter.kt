package com.example.turkey.views.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.turkey.DataBase.CityEntity
import com.example.turkey.R
import com.example.turkey.views.WantCityDirections

class WantCityAdapter(private val wantCityDataSet: ArrayList<CityEntity>) : RecyclerView.Adapter<WantCityAdapter.CityWantHolder>() {

    class CityWantHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cityNameText: TextView = itemView.findViewById(R.id.cityNameRawTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityWantHolder {
        return CityWantHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.city_name_raw, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return wantCityDataSet.size
    }

    override fun onBindViewHolder(holder: CityWantHolder, position: Int) {
        val city = wantCityDataSet[position]
        holder.cityNameText.text = city.cityName

        holder.itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putString("cityName", city.cityName)
                putString("cityImage", city.cityImage)
                putString("cityVisit", city.cityVisit)
                putString("cityFood", city.cityFood)
            }

            val action = WantCityDirections.actionWantCityToCityDetail()
            Navigation.findNavController(it).navigate(action.actionId, bundle)
        }
    }
}
