package com.example.turkey.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.turkey.databinding.FragmentVisitCityBinding
import com.example.turkey.models.CityDtoDetail
import com.example.turkey.services.CityDetailServices
import com.example.turkey.viewmodels.CityApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VisitCity : Fragment() {
    private lateinit var binding: FragmentVisitCityBinding
    private lateinit var visitCityText: TextView
    private var detailService: CityDetailServices? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVisitCityBinding.inflate(inflater, container, false)
        visitCityText = binding.visitCityText
        val cityName = arguments?.getString("cityName")
        fetchCityDetails(cityName)
        return binding.root
    }

    private fun fetchCityDetails(cityName: String?) {
        detailService = CityApiClient.getClient().create(CityDetailServices::class.java)
        if (cityName != null) {
            val call = detailService?.getCityByName(cityName)

            call?.enqueue(object : Callback<CityDtoDetail> {
                override fun onFailure(call: Call<CityDtoDetail>, t: Throwable) {
                    Log.e("VisitCity", "Error fetching city details: ${t.message}")
                }

                override fun onResponse(
                    call: Call<CityDtoDetail>,
                    response: Response<CityDtoDetail>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { city ->
                            visitCityText.text = city.cityName
                        }
                        println(response.body())
                    }
                }
            })
        } else {
            Log.e("VisitCity", "City name is null")
        }
    }

}

