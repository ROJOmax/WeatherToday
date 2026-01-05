package com.rojo.weattherToday.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: WeatherEntity)

    @Query("SELECT * FROM weather_cache WHERE cityName = :cityName")
    fun getWeatherByCityFlow(cityName: String): Flow<WeatherEntity?>

    @Query("SELECT * FROM weather_cache WHERE cityName = :cityName")
    suspend fun getWeatherByCity(cityName: String): WeatherEntity?

    @Query("DELETE FROM weather_cache WHERE cityName = :cityName")
    suspend fun deleteWeather(cityName: String)

    @Query("DELETE FROM weather_cache")
    suspend fun clearAll()

    @Query("SELECT * FROM weather_cache")
    fun getAllWeather(): Flow<List<WeatherEntity>>
}