package com.example.turkey.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.turkey.DataBase.CityEntity
import com.example.turkey.R

class WantCityAdapter (private val wantCityDataSet:ArrayList<CityEntity>):RecyclerView.Adapter<WantCityAdapter.CityWantHolder>(){
    class CityWantHolder (itemView:View):RecyclerView.ViewHolder(itemView){
        val cityNameText:TextView

        init {
            cityNameText=itemView.findViewById(R.id.wantCityTextView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityWantHolder {
        return CityWantHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.want_city_raw,parent,false)
        )

    }

    override fun getItemCount(): Int {
        return wantCityDataSet.size
    }

    override fun onBindViewHolder(holder: CityWantHolder, position: Int) {
        holder.cityNameText.text=wantCityDataSet[position].cityName
    }
}