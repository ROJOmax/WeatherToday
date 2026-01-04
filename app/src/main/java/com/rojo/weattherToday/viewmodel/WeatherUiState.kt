package com.rojo.weattherToday.viewmodel

import com.rojo.weattherToday.data.local.ForecastEntity
import com.rojo.weattherToday.data.local.WeatherEntity


sealed class WeatherUiState {
    object Initial : WeatherUiState()
    object Loading: WeatherUiState()
    data class Success(val weather: WeatherEntity) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}

sealed class ForecastUiState {
    object Initial : ForecastUiState()
    object Loading : ForecastUiState()
    data class Success(val forecasts: List<ForecastEntity>) : ForecastUiState()
    data class Error(val message: String) : ForecastUiState()
}