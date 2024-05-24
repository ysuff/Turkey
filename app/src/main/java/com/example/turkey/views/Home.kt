package com.example.turkey.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.turkey.R
import com.example.turkey.databinding.FragmentHomeBinding
import com.example.turkey.views.adapters.PhotoSliderAdapter

class Home : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var buttonNext: Button
    private lateinit var buttonBack: Button
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonNext = binding.buttonNext
        buttonBack = binding.buttonBack
        viewPager = binding.viewPager

        val images = listOf(
            R.drawable.adana,
            R.drawable.ankara,
            R.drawable.adiyaman,
            R.drawable.afyonkarahisar
        )

        val adapter = PhotoSliderAdapter(images)
        viewPager.adapter = adapter

        buttonNext.setOnClickListener {
            val nextItem = (viewPager.currentItem + 1) % images.size
            viewPager.setCurrentItem(nextItem, true)
        }

        buttonBack.setOnClickListener {
            val previousItem = if (viewPager.currentItem - 1 < 0) images.size - 1 else viewPager.currentItem - 1
            viewPager.setCurrentItem(previousItem, true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
