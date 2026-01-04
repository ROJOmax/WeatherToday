package com.rojo.weattherToday.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ForecastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecasts(forecasts: List<ForecastEntity>)

    @Query("SELECT * FROM forecast_cache WHERE cityName = :cityName ORDER BY timestamp ASC")
    fun getForecastsByCityFlow(cityName: String): Flow<List<ForecastEntity>>

    @Query("SELECT * FROM forecast_cache WHERE cityName = :cityName ORDER BY timestamp ASC")
    suspend fun getForecastsByCity(cityName: String): List<ForecastEntity>

    @Query("DELETE FROM forecast_cache WHERE cityName = :cityName")
    suspend fun deleteForecasts(cityName: String)

    @Query("DELETE FROM forecast_cache")
    suspend fun clearAll()
}