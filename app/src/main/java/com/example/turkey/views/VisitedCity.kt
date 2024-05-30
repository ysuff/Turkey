package com.example.turkey.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.turkey.DataBase.FireBase.DatabaseFirebase
import com.example.turkey.databinding.FragmentVisitedCityBinding
import com.example.turkey.views.adapters.VisitedCityAdapter
import com.google.firebase.database.*

class VisitedCity : Fragment() {
    private lateinit var binding: FragmentVisitedCityBinding
    private lateinit var visitedCityRecyclerView: RecyclerView
    private lateinit var contactList: ArrayList<DatabaseFirebase>
    private lateinit var firebaseRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVisitedCityBinding.inflate(inflater, container, false)
        visitedCityRecyclerView = binding.visitedCityRecyclerView
        firebaseRef = FirebaseDatabase.getInstance().getReference("Cities")
        contactList = arrayListOf()

        fetchData()
        visitedCityRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
        }

        return binding.root
    }

    private fun fetchData() {
        firebaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    contactList.clear()
                    for (contactSnap in snapshot.children) {
                        val cityName = contactSnap.getValue(String::class.java)
                        if (cityName != null) {
                            val city = DatabaseFirebase(cityName)
                            contactList.add(city)
                        }
                    }
                    val adapter = VisitedCityAdapter(contactList)
                    visitedCityRecyclerView.adapter = adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}
