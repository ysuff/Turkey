package com.example.turkey.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.turkey.R


data class CityCustomAdapterType(
    val cityAdapterId: Int = 0,
    val cityNameTitle: String = ""
)


class CityRecyclerCustomAdapter(private val cityAdapterDataSet: MutableList<CityCustomAdapterType>) :
    RecyclerView.Adapter<CityRecyclerCustomAdapter.CityAdapterHolder>() {


    class CityAdapterHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cityTextView: TextView = view.findViewById(R.id.itemText)
    }


    override fun onCreateViewHolder(cityViewGroup: ViewGroup, viewType: Int): CityAdapterHolder {
        val cityView = LayoutInflater.from(cityViewGroup.context)
            .inflate(R.layout.city_item, cityViewGroup, false)
        return CityAdapterHolder(cityView)
    }

    override fun onBindViewHolder(holder: CityAdapterHolder, position: Int) {
        val currentCity = cityAdapterDataSet[position]
        holder.cityTextView.text = currentCity.cityNameTitle

    }


    override fun getItemCount() = cityAdapterDataSet.size
}