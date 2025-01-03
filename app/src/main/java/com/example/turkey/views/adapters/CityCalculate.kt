package com.example.turkey.views.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.turkey.R
import com.example.turkey.databinding.FragmentCityCalculateBinding
import com.example.turkey.views.Tree

class CityCalculate : Fragment() {
    private lateinit var binding: FragmentCityCalculateBinding
    private lateinit var startCityEdit: EditText
    private lateinit var endCityEdit: EditText
    private lateinit var resultText: TextView
    private lateinit var calculateButton: Button
    private val tree = Tree()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCityCalculateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calculateButton = binding.calculateButton
        startCityEdit = binding.startCityEdit
        endCityEdit = binding.endCityEdit
        resultText = binding.resultText

        calculateButton.setOnClickListener {
            val startCity = startCityEdit.text.toString().trim()
            val endCity = endCityEdit.text.toString().trim()

            if (startCity.isBlank() || endCity.isBlank()) {
                resultText.text = "Lütfen başlangıç ve bitiş şehirlerini giriniz!"
            } else {
                resultText.text = findShortestPath(startCity, endCity)
            }
        }
    }

    private fun findShortestPath(start: String, end: String): String {
        val queue = ArrayDeque<Pair<String, List<String>>>()
        queue.add(Pair(start, listOf(start)))

        while (queue.isNotEmpty()) {
            val (currentCity, path) = queue.removeFirst()

            if (currentCity == end) {
                return "En Kısa Rota: ${path.joinToString(" -> ")}"
            }

            for (neighbor in tree.getNeighbors(currentCity)) {
                if (neighbor !in path) { //
                    queue.add(Pair(neighbor, path + neighbor))
                }
            }
        }

        return "Bitiş şehrine giden bir yol bulunamadı!"
    }
}
