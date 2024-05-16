package com.example.turkey.services

import com.example.turkey.models.CityDtoDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface CityDetailServices {
    @GET("provinces")
    fun getCityByName(@Query("name") name: String): Call<CityDtoDetail>
}

