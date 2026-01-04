package com.rojo.weattherToday.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_cache")
data class WeatherEntity(
    @PrimaryKey
    val cityName: String,
    val temperature: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int,
    val weatherMain: String,
    val weatherDescription: String,
    val weatherIcon: String,
    val windSpeed: Double,
    val cloudiness: Int,
    val country: String,
    val timestamp: Long, // When data was cached
    val sunrise: Long,
    val sunset: Long
)