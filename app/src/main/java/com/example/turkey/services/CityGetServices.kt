package com.example.turkey.services

import com.example.turkey.models.CityResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface CityGetServices {

    @GET("provinces")
    fun get(@Query("name") cityName: String): Call<CityResult>
}

