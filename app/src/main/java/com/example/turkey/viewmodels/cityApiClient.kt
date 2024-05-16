package com.example.turkey.viewmodels

import androidx.room.util.query
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CityApiClient {

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null)
            retrofit = Retrofit.Builder()
                .baseUrl("https://turkiyeapi.dev/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit as Retrofit

    }


}





