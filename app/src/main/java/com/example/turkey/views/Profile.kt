package com.example.turkey.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.findNavController
import com.example.turkey.R
import com.example.turkey.databinding.FragmentProfileBinding

class Profile : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var buttonWantedCity:LinearLayout
    private lateinit var buttonMaps:LinearLayout
    private lateinit var buttonChatBot:LinearLayout
    private lateinit var buttonVisitedCity:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        buttonWantedCity=binding.buttonWantedCity
        buttonMaps=binding.buttonMaps
        buttonChatBot=binding.buttonChatBot
        buttonVisitedCity=binding.buttonVisitedCity

        binding.buttonMaps.setOnClickListener {
            val goMapsPage = R.id.action_profile_to_mainActivityTwo
            it.findNavController().navigate(goMapsPage)
        }

        binding.buttonChatBot.setOnClickListener {
            val goChatBotPage = R.id.action_profile_to_chatBot
            it.findNavController().navigate(goChatBotPage)
        }

        binding.buttonVisitedCity.setOnClickListener {
            val goVisitedPage = R.id.action_profile_to_visitedCity
            it.findNavController().navigate(goVisitedPage)
        }

        binding.buttonWantedCity.setOnClickListener {
            val goWantPage = R.id.action_profile_to_cityCalculate
            it.findNavController().navigate(goWantPage)
        }

        return binding.root
    }
}
