
package com.example.turkey.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "city_table")
data class CityEntity(
    @PrimaryKey
    val cityName: String,
    val cityImage: String?,
    val cityVisit: String?,
    val cityFood: String?
)
