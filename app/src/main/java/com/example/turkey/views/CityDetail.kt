package com.example.turkey.views

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.turkey.DataBase.CityEntity
import com.example.turkey.DataBase.CityViewModel
import com.example.turkey.R
import com.example.turkey.databinding.FragmentCityDetailBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*

class CityDetail : Fragment() {
    private lateinit var binding: FragmentCityDetailBinding
    private var cityName: String? = null
    private var cityImage: String? = null
    private var cityVisit: String? = null
    private var cityFood: String? = null

    private lateinit var cityViewModel: CityViewModel
    private lateinit var databaseReference: DatabaseReference
    private lateinit var textViewVisitPlaces:TextView
    private lateinit var textViewFamousFoods:TextView
    private lateinit var textViewVisitPlacesHeader:TextView
    private lateinit var textViewFamousFoodsHeader:TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FirebaseApp.initializeApp(requireContext())
        binding = FragmentCityDetailBinding.inflate(layoutInflater, container, false)
        textViewVisitPlaces=binding.textViewVisitPlaces
        textViewFamousFoods=binding.textViewFamousFoods
        textViewVisitPlacesHeader=binding.textViewVisitPlacesHeader
        textViewFamousFoodsHeader=binding.textViewFamousFoodsHeader

        setupViewModel()
        initializeFirebaseDatabase()
        populateCityDetails()
        checkCityInFavorites()

        textViewVisitPlacesHeader.setOnClickListener {
            toggleVisibility(textViewVisitPlaces, textViewFamousFoods)
        }

        textViewFamousFoodsHeader.setOnClickListener {
            toggleVisibility(textViewFamousFoods, textViewVisitPlaces)
        }

        binding.buttonCheckAdd.setOnClickListener {
            if (binding.buttonCheckAdd.tag == "RED") {
                addCityToFavorites()
            } else if (binding.buttonCheckAdd.tag == "GREEN") {
                removeCityFromFavorites()
            }
        }

        binding.buttonVisitAdd.setOnClickListener {
            addCityNameToFirebase()
        }

        return binding.root
    }

    private fun initializeFirebaseDatabase() {
        databaseReference = FirebaseDatabase.getInstance().getReference("Cities")
    }

    private fun populateCityDetails() {
        cityImage = arguments?.getString("cityImage", "")
        cityName = arguments?.getString("cityName", "")
        cityVisit = arguments?.getString("cityVisit", "")
        cityFood = arguments?.getString("cityFood", "")

        binding.textViewCityName.text = cityName
        binding.textViewVisitPlaces.text = cityVisit
        binding.textViewFamousFoods.text = cityFood

        cityImage?.let {
            val drawableId = resources.getIdentifier(it, "drawable", requireContext().packageName)
            Glide.with(this)
                .load(drawableId)
                .placeholder(R.drawable.ankara)
                .into(binding.imageViewCity)
        }
    }

    private fun setupViewModel() {
        cityViewModel = ViewModelProvider(this).get(CityViewModel::class.java)
    }

    private fun checkCityInFavorites() {
        cityViewModel.readAllData.observe(viewLifecycleOwner, { cities ->
            val isFavorite = cities.any { it.cityName == cityName }
            if (isFavorite) {
                binding.buttonCheckAdd.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.green))
                binding.buttonCheckAdd.tag = "GREEN"
            } else {
                binding.buttonCheckAdd.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.red))
                binding.buttonCheckAdd.tag = "RED"
            }
        })
    }

    private fun addCityToFavorites() {
        val cityEntity = CityEntity(cityName ?: "", cityImage, cityVisit, cityFood)
        cityViewModel.addCity(cityEntity)
        binding.buttonCheckAdd.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.green))
        binding.buttonCheckAdd.tag = "GREEN"
        Toast.makeText(requireContext(), "City added to favorites", Toast.LENGTH_SHORT).show()
    }

    private fun removeCityFromFavorites() {
        cityName?.let {
            cityViewModel.deleteCityByName(it)
            binding.buttonCheckAdd.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.red))
            binding.buttonCheckAdd.tag = "RED"
            Toast.makeText(requireContext(), "City removed from favorites", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addCityNameToFirebase() {
        if (cityName.isNullOrEmpty()) return

        databaseReference.orderByValue().equalTo(cityName).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    Toast.makeText(requireContext(), "City already exists in Firebase", Toast.LENGTH_SHORT).show()
                } else {
                    val cityId = databaseReference.push().key ?: return
                    databaseReference.child(cityId).setValue(cityName)
                        .addOnSuccessListener {
                            Toast.makeText(requireContext(), "City name added to Firebase", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(requireContext(), "Failed to add city name to Firebase: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(requireContext(), "Database error: ${databaseError.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun toggleVisibility(viewToShow: View, viewToHide: View) {
        if (viewToShow.visibility == View.VISIBLE) {
            viewToShow.visibility = View.GONE
        } else {
            viewToShow.visibility = View.VISIBLE
            viewToHide.visibility = View.GONE
        }
    }
}
