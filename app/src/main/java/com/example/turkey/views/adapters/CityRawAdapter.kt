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
    private val cityName: ArrayList<String>,
    private val cityImageView: ArrayList<Int>,
    private val cityVisit: ArrayList<String>,
    private val cityFood: ArrayList<String>
) :
    RecyclerView.Adapter<CityRawAdapter.CityNameList>() {
    class CityNameList(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityNameList {

        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.city_name_raw, parent, false)
        return CityNameList(itemView)
    }

    override fun getItemCount(): Int {
        return cityName.size

    }

    override fun onBindViewHolder(holder: CityNameList, position: Int) {
        val cityNameTextView = holder.itemView.findViewById<TextView>(R.id.cityNameRawTextView)
        cityNameTextView.text = cityName[position]

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("cityName", cityName[position])
            bundle.putString("cityVisit", cityVisit[position])
            bundle.putString("cityFood", cityFood[position])
            bundle.putString("cityImage", cityImageView[position].toString())

            val action = CityNameDirections.actionCityNameToCityDetail()
            Navigation.findNavController(it).navigate(action.actionId, bundle)
        }
    }


}
