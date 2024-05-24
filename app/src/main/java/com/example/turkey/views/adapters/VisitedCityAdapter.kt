package com.example.turkey.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.turkey.DataBase.FireBase.DatabaseFirebase
import com.example.turkey.R

class VisitedCityAdapter(private val visitedCityDataSet: ArrayList<DatabaseFirebase>) :
    RecyclerView.Adapter<VisitedCityAdapter.CityViewHolder>() {

    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val visitCityName: TextView = itemView.findViewById(R.id.visitedCityRawTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.visited_raw, parent, false)
        return CityViewHolder(view)
    }

    override fun getItemCount(): Int = visitedCityDataSet.size

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val currentItem = visitedCityDataSet[position]
        holder.visitCityName.text = currentItem.cityNameFirebase
    }
}
