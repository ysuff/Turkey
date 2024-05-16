package com.example.turkey.views
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.turkey.DataBase.CityEntity
import com.example.turkey.databinding.FragmentCityDetailBinding
import com.example.turkey.DataBase.CityViewModel

class CityDetail : Fragment() {
    private lateinit var binding: FragmentCityDetailBinding
    private lateinit var cityDetailCityNameTextView: TextView
    private lateinit var cityDetailImageView: ImageView
    private lateinit var cityDetailVisitPlaceTextView:TextView
    private lateinit var cityDetailCityFoodTextView:TextView
    private lateinit var checkButtonAdd:Button
    private lateinit var visitAddButton:Button

    private var cityName: String? = null
    private var cityImage: String? = null
    private var cityVisit: String? = null
    private var cityFood: String? = null

    private lateinit var cityViewModel: CityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCityDetailBinding.inflate(layoutInflater, container, false)

        cityDetailCityNameTextView = binding.cityDetailCityNameTextView
        cityDetailImageView = binding.cityDetailImageView
        cityDetailVisitPlaceTextView = binding.cityDetailVisitPlaceTextView
        cityDetailCityFoodTextView = binding.cityDetailCityFoodTextView
        checkButtonAdd = binding.checkButtonAdd
        visitAddButton = binding.visitAddButton
        city()
        setupViewModel()

        checkButtonAdd.setOnClickListener {
            val cityEntity = cityName?.let { it1 -> CityEntity(it1, cityImage, cityVisit, cityFood) }
            if (cityEntity != null) {
                cityViewModel.addCity(cityEntity)
            }
            Toast.makeText(requireContext(), "City added to favorites", Toast.LENGTH_SHORT).show()
        }


        return binding.root
    }




    private fun city(){
        cityImage = arguments?.getString("cityImage","")
        cityName = arguments?.getString("cityName","")
        cityVisit = arguments?.getString("cityVisit","")
        cityFood = arguments?.getString("cityFood","")

        cityDetailCityNameTextView.text = cityName
        cityDetailVisitPlaceTextView.text=cityVisit
        cityDetailCityFoodTextView.text=cityFood

        cityImage?.let {
            val drawableId = resources.getIdentifier(it, "drawable", requireContext().packageName)
            cityDetailImageView.setImageResource(drawableId)
        }

    }
    private fun setupViewModel(){
        cityViewModel = ViewModelProvider(this).get(CityViewModel::class.java)

    }

}