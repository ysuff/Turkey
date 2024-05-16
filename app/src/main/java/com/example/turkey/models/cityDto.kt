package com.example.turkey.models

import com.google.gson.annotations.SerializedName

data class CityDto(
    @SerializedName("id") val cityId: Int = 0,
    @SerializedName("name") val cityName: String = "",
    @SerializedName("population") val cityPopulation: Double = 0.2,


    )

data class CityResult(
    @SerializedName("status") val cityStatus: String = "",
    @SerializedName("data") val searchResults: List<CityDto>,

    )

