package com.example.turkey.DataBase

import com.example.turkey.DataBase.CityDao
import androidx.lifecycle.LiveData
import com.example.turkey.DataBase.CityEntity

class CityRepository(private val cityDao: CityDao) {
    val readAllData: LiveData<List<CityEntity>> = cityDao.readAllData()

    suspend fun addCity(cityEntity: CityEntity) {
        cityDao.addCity(cityEntity)
    }

    fun getCityByName(cityName: String): LiveData<CityEntity?> {
        return cityDao.getCityByName(cityName)
    }

    suspend fun deleteCity(city: CityEntity) {
        cityDao.deleteCity(city)
    }

    suspend fun deleteAllCities() {
        cityDao.deleteAllCities()
    }
}