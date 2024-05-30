package com.example.turkey.DataBase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CityDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCity(city: CityEntity)

    @Query("SELECT * FROM city_table ORDER BY cityName ASC")
    fun readAllData(): LiveData<List<CityEntity>>

    @Query("SELECT * FROM city_table WHERE cityName = :cityName LIMIT 1")
    fun getCityByName(cityName: String): LiveData<CityEntity?>

    @Delete
    suspend fun deleteCity(city: CityEntity)

    @Query("DELETE FROM city_table WHERE cityName = :cityName")
    suspend fun deleteCityByName(cityName: String)

    @Query("DELETE FROM city_table")
    suspend fun deleteAllCities()
}
