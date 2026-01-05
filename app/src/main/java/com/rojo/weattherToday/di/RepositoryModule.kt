package com.rojo.weattherToday.di

import com.rojo.weattherToday.data.local.ForecastDao
import com.rojo.weattherToday.data.local.WeatherDao
import com.rojo.weattherToday.data.remote.WeatherApiService
import com.rojo.weattherToday.data.repository.WeatherRepository
import com.rojo.weattherToday.data.repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(
        apiService: WeatherApiService,
        weatherDao: WeatherDao,
        forecastDao: ForecastDao
    ): WeatherRepository {
        return WeatherRepositoryImpl(apiService, weatherDao, forecastDao)
    }
}