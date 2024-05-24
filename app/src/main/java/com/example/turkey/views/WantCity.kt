package com.example.turkey.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.turkey.DataBase.CityEntity
import com.example.turkey.DataBase.CityViewModel
import com.example.turkey.R
import com.example.turkey.databinding.FragmentWantCityBinding
import com.example.turkey.views.adapters.WantCityAdapter


class WantCity : Fragment() {
private lateinit var binding: FragmentWantCityBinding
private lateinit var cityViewModel: CityViewModel
private lateinit var wantCityRecyclerView: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentWantCityBinding.inflate(layoutInflater,container,false)
        wantCityRecyclerView=binding.wantCityRecyclerView

        val cityDataSet=ArrayList<CityEntity>()
        val cityViewAdapter= WantCityAdapter(cityDataSet)
        wantCityRecyclerView.adapter=cityViewAdapter

        wantCityRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this.context)
        }

        cityViewModel=ViewModelProvider(this).get(CityViewModel::class.java)
        cityViewModel.readAllData.observe(viewLifecycleOwner,{ cityList ->
            for (city in cityList){
                cityDataSet.add(city)
                cityViewAdapter.notifyItemInserted(cityDataSet.indexOf(city))
            }
            cityViewAdapter.notifyDataSetChanged()

        })



        return binding.root
    }


}