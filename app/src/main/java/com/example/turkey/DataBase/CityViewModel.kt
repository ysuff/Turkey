package com.example.turkey.DataBase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CityViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: CityRepository
    val readAllData: LiveData<List<CityEntity>>

    init {
        val cityDao = CityDatabase.getDatabase(application).cityDao()
        repository = CityRepository(cityDao)
        readAllData = repository.readAllData
    }

    fun addCity(cityEntity: CityEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCity(cityEntity)
        }
    }

    fun getCityByName(cityName: String): LiveData<CityEntity?> {
        return repository.getCityByName(cityName)
    }

    fun deleteCity(city: CityEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCity(city)
        }
    }

    fun deleteCityByName(cityName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCityByName(cityName)
        }
    }

    fun deleteAllCities() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCities()
        }
    }
}
