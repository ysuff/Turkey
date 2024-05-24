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
import com.bumptech.glide.Glide
import com.example.turkey.DataBase.CityEntity
import com.example.turkey.databinding.FragmentCityDetailBinding
import com.example.turkey.DataBase.CityViewModel
import com.example.turkey.R
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*

class CityDetail : Fragment() {
    private lateinit var binding: FragmentCityDetailBinding
    private lateinit var cityDetailCityNameTextView: TextView
    private lateinit var cityDetailImageView: ImageView
    private lateinit var cityDetailVisitPlaceTextView: TextView
    private lateinit var cityDetailCityFoodTextView: TextView
    private lateinit var checkButtonAdd: Button
    private lateinit var visitAddButton: Button

    private var cityName: String? = null
    private var cityImage: String? = null
    private var cityVisit: String? = null
    private var cityFood: String? = null

    private lateinit var cityViewModel: CityViewModel
    private lateinit var databaseReference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FirebaseApp.initializeApp(requireContext())
        binding = FragmentCityDetailBinding.inflate(layoutInflater, container, false)

        cityDetailCityNameTextView = binding.cityDetailCityNameTextView
        cityDetailImageView = binding.cityDetailImageView
        cityDetailVisitPlaceTextView = binding.cityDetailVisitPlaceTextView
        cityDetailCityFoodTextView = binding.cityDetailCityFoodTextView
        checkButtonAdd = binding.checkButtonAdd
        visitAddButton = binding.visitAddButton

        setupViewModel()
        initializeFirebaseDatabase()
        populateCityDetails()

        checkButtonAdd.setOnClickListener {
            addCityToFavorites()
        }

        visitAddButton.setOnClickListener {
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

        cityDetailCityNameTextView.text = cityName
        cityDetailVisitPlaceTextView.text = cityVisit
        cityDetailCityFoodTextView.text = cityFood

        cityImage?.let {
            val drawableId = resources.getIdentifier(it, "drawable", requireContext().packageName)
            Glide.with(this)
                .load(drawableId)
                .placeholder(R.drawable.ankara)
                .into(cityDetailImageView)
        }
    }

    private fun setupViewModel() {
        cityViewModel = ViewModelProvider(this).get(CityViewModel::class.java)
    }

    private fun addCityToFavorites() {
        val cityEntity = CityEntity(cityName ?: "", cityImage, cityVisit, cityFood)
        cityViewModel.addCity(cityEntity)
        Toast.makeText(requireContext(), "City added to favorites", Toast.LENGTH_SHORT).show()
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
}
