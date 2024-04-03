package com.example.turkey.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.turkey.databinding.FragmentCitiesToVisitBinding


private lateinit var binding: FragmentCitiesToVisitBinding

class citiesToVisit : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCitiesToVisitBinding.inflate(inflater, container, false)
        return binding.root

    }


}