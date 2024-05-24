package com.example.turkey.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.turkey.databinding.FragmentCityBinding
import com.example.turkey.models.CityResult
import com.example.turkey.services.CityGetServices
import com.example.turkey.viewmodels.CityApiClient
import com.example.turkey.views.adapters.CityCustomAdapterType
import com.example.turkey.views.adapters.CityRecyclerCustomAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class city : Fragment() {

    private lateinit var binding: FragmentCityBinding
    private lateinit var cityGetServices: CityGetServices
    private lateinit var citySearchView: SearchView
    private lateinit var cityRecyclerView: RecyclerView
    private var cityDataSet = ArrayList<CityCustomAdapterType>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCityBinding.inflate(inflater, container, false)

        citySearchView = binding.cityFragmentSearchView
        cityRecyclerView = binding.cityFragmentRecyclerView

        cityRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
        }

        cityGetServices = CityApiClient.getClient().create(CityGetServices::class.java)

        val cityAdapter = CityRecyclerCustomAdapter(cityDataSet)
        cityRecyclerView.adapter = cityAdapter

        citySearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchCity(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        return binding.root
    }

    private fun searchCity(query: String) {
        cityDataSet.clear()
        cityGetServices.get(query).enqueue(object : Callback<CityResult> {
            override fun onResponse(call: Call<CityResult>, response: Response<CityResult>) {
                if (response.isSuccessful) {
                    val searchResults = response.body()?.searchResults
                    if (!searchResults.isNullOrEmpty()) {
                        cityDataSet.addAll(searchResults.map {
                            CityCustomAdapterType(cityNameTitle = it.cityName)
                        })
                        cityRecyclerView.adapter?.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<CityResult>, t: Throwable) {
                println("Error: $t")
            }
        })
    }
}
