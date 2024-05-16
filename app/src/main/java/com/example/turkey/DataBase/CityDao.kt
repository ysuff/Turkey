package com.example.turkey.DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CityDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCity(cityEntity: CityEntity)

    @Query("SELECT * FROM city_table WHERE cityName = :cityName")
    fun getCityByName(cityName: String): LiveData<CityEntity?>

    @Query("SELECT * FROM city_table ORDER BY cityName")
    fun readAllData(): LiveData<List<CityEntity>>

    @Delete
    suspend fun deleteCity(city: CityEntity)

    @Query("DELETE FROM city_table")
    suspend fun deleteAllCities()
}