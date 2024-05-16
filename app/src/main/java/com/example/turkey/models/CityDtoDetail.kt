package com.example.turkey.models

import com.google.gson.annotations.SerializedName

data class CityDtoDetail(
    @SerializedName("id") var cityId:Int,
    @SerializedName("population") var cityPopulation:Int=0,
    @SerializedName("altitude") var cityAltitude:Int=0,
    @SerializedName("name") var cityName:String="",
    @SerializedName("region") var cityRegion:String="",
    @SerializedName("googleMaps") var cityMaps:String="",




)


