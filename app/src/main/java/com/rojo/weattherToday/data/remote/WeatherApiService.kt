package com.rojo.weattherToday.data.remote

import com.rojo.weattherToday.data.model.ForecastResponse
import com.rojo.weattherToday.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApiService {

    /**
     * Fetches current weather for a city
     * @param cityName Name of the city
     * @param apiKey Your OpenWeatherMap API key
     * @param units Temperature unit (metric, imperial, standard)
     */
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): Response<WeatherResponse>

    /**
     * Fetches 5-day weather forecast
     * @param cityName Name of the city
     * @param apiKey Your OpenWeatherMap API key
     * @param units Temperature unit
     */
    @GET("forecast")
    suspend fun getForecast(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): Response<ForecastResponse>

    /**
     * Fetches current weather by coordinates
     */
    @GET("weather")
    suspend fun getCurrentWeatherByCoordinates(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): Response<WeatherResponse>
}