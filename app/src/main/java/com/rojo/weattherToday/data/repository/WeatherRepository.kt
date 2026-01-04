package com.rojo.weattherToday.data.repository

import com.rojo.weattherToday.data.local.ForecastEntity
import com.rojo.weattherToday.data.local.WeatherEntity
import com.rojo.weattherToday.data.remote.Result
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    // Current Weather
    suspend fun getCurrentWeather(cityName: String, forceRefresh: Boolean = false): Result<WeatherEntity>
    fun getWeatherFlow(cityName: String): Flow<WeatherEntity?>

    // Forecast
    suspend fun getForecast(cityName: String, forceRefresh: Boolean = false): Result<List<ForecastEntity>>
    fun getForecastFlow(cityName: String): Flow<List<ForecastEntity>>

    // Cache Management
    suspend fun clearCache()
}