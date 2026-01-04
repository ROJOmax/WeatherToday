package com.rojo.weattherToday.data.local


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "forecast_cache")
data class ForecastEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val cityName: String,
    val timestamp: Long,
    val temperature: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val weatherMain: String,
    val weatherDescription: String,
    val weatherIcon: String,
    val windSpeed: Double,
    val probabilityOfPrecipitation: Double,
    val dateTimeText: String,
    val cacheTime: Long // When data was cached
)