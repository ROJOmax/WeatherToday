package com.rojo.weattherToday.data.repository

import com.rojo.weattherToday.BuildConfig
import com.rojo.weattherToday.data.local.ForecastDao
import com.rojo.weattherToday.data.local.ForecastEntity
import com.rojo.weattherToday.data.local.WeatherDao
import com.rojo.weattherToday.data.local.WeatherEntity
import com.rojo.weattherToday.data.model.ForecastResponse
import com.rojo.weattherToday.data.model.WeatherResponse
import com.rojo.weattherToday.data.remote.Result
import com.rojo.weattherToday.data.remote.WeatherApiService
import com.rojo.weattherToday.data.remote.safeApiCall
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: WeatherApiService,
    private val weatherDao: WeatherDao,
    private val forecastDao: ForecastDao
) : WeatherRepository {

    companion object {
        private const val CACHE_TIMEOUT = 30 * 60 * 1000L // 30 minutes
    }

    override suspend fun getCurrentWeather(
        cityName: String,
        forceRefresh: Boolean
    ): Result<WeatherEntity> {
        // Check cache first (if not forcing refresh)
        if (!forceRefresh) {
            val cachedWeather = weatherDao.getWeatherByCity(cityName)
            if (cachedWeather != null && !isCacheExpired(cachedWeather.timestamp)) {
                return Result.Success(cachedWeather)
            }
        }

        // Fetch from network
        return when (val result = safeApiCall {
            apiService.getCurrentWeather(cityName, BuildConfig.WEATHER_API_KEY)
        }) {
            is Result.Success -> {
                val entity = mapWeatherResponseToEntity(result.data)
                weatherDao.insertWeather(entity)
                Result.Success(entity)
            }
            is Result.Error -> result
            is Result.Loading -> result
        }
    }

    override fun getWeatherFlow(cityName: String): Flow<WeatherEntity?> {
        return weatherDao.getWeatherByCityFlow(cityName)
    }

    override suspend fun getForecast(
        cityName: String,
        forceRefresh: Boolean
    ): Result<List<ForecastEntity>> {
        // Check cache first
        if (!forceRefresh) {
            val cachedForecast = forecastDao.getForecastsByCity(cityName)
            if (cachedForecast.isNotEmpty() && !isCacheExpired(cachedForecast.first().cacheTime)) {
                return Result.Success(cachedForecast)
            }
        }

        // Fetch from network
        return when (val result = safeApiCall {
            apiService.getForecast(cityName, BuildConfig.WEATHER_API_KEY)
        }) {
            is Result.Success -> {
                val entities = mapForecastResponseToEntities(result.data, cityName)
                // Clear old forecasts for this city
                forecastDao.deleteForecasts(cityName)
                // Insert new forecasts
                forecastDao.insertForecasts(entities)
                Result.Success(entities)
            }
            is Result.Error -> result
            is Result.Loading -> result
        }
    }

    override fun getForecastFlow(cityName: String): Flow<List<ForecastEntity>> {
        return forecastDao.getForecastsByCityFlow(cityName)
    }

    override suspend fun clearCache() {
        weatherDao.clearAll()
        forecastDao.clearAll()
    }

    private fun isCacheExpired(cacheTimestamp: Long): Boolean {
        return System.currentTimeMillis() - cacheTimestamp > CACHE_TIMEOUT
    }

    //  API model -> Database entity
    private fun mapWeatherResponseToEntity(response: WeatherResponse): WeatherEntity {
        return WeatherEntity(
            cityName = response.cityName,
            temperature = response.main.temperature,
            feelsLike = response.main.feelsLike,
            tempMin = response.main.tempMin,
            tempMax = response.main.tempMax,
            pressure = response.main.pressure,
            humidity = response.main.humidity,
            weatherMain = response.weather.firstOrNull()?.main ?: "",
            weatherDescription = response.weather.firstOrNull()?.description ?: "",
            weatherIcon = response.weather.firstOrNull()?.icon ?: "",
            windSpeed = response.wind.speed,
            cloudiness = response.clouds.cloudiness,
            country = response.sys.country,
            timestamp = System.currentTimeMillis(),
            sunrise = response.sys.sunrise,
            sunset = response.sys.sunset
        )
    }

    private fun mapForecastResponseToEntities(
        response: ForecastResponse,
        cityName: String
    ): List<ForecastEntity> {
        val currentTime = System.currentTimeMillis()
        return response.forecastList.map { item ->
            ForecastEntity(
                cityName = cityName,
                timestamp = item.timestamp,
                temperature = item.main.temperature,
                feelsLike = item.main.feelsLike,
                tempMin = item.main.tempMin,
                tempMax = item.main.tempMax,
                weatherMain = item.weather.firstOrNull()?.main ?: "",
                weatherDescription = item.weather.firstOrNull()?.description ?: "",
                weatherIcon = item.weather.firstOrNull()?.icon ?: "",
                windSpeed = item.wind.speed,
                probabilityOfPrecipitation = item.probabilityOfPrecipitation,
                dateTimeText = item.dateTimeText,
                cacheTime = currentTime
            )
        }
    }
}