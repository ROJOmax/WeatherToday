package com.rojo.weattherToday.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rojo.weattherToday.data.remote.Result
import com.rojo.weattherToday.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    private val _weatherState = MutableStateFlow<WeatherUiState>(WeatherUiState.Initial)
    val weatherState: StateFlow<WeatherUiState> = _weatherState.asStateFlow()

    private val _forecastState = MutableStateFlow<ForecastUiState>(ForecastUiState.Initial)
    val forecastState: StateFlow<ForecastUiState> = _forecastState.asStateFlow()

    private val _selectedCity = MutableStateFlow<String?>(null)
    val selectedCity: StateFlow<String?> = _selectedCity.asStateFlow()

    fun loadWeather(cityName: String, forceRefresh: Boolean = false) {
        viewModelScope.launch {
            _weatherState.value = WeatherUiState.Loading
            _selectedCity.value = cityName

            when (val result = repository.getCurrentWeather(cityName, forceRefresh)) {
                is Result.Success -> {
                    _weatherState.value = WeatherUiState.Success(result.data)
                }
                is Result.Error -> {
                    _weatherState.value = WeatherUiState.Error(
                        result.exception.message ?: "Unknown error occurred"
                    )
                }
                is Result.Loading -> {
                    // TODO handle loading state
                }
            }
        }
    }

    fun loadForecast(cityName: String, forceRefresh: Boolean) {
        viewModelScope.launch {
            _forecastState.value = ForecastUiState.Loading

            when (val result = repository.getForecast(cityName, forceRefresh)) {
                is Result.Success -> {
                    _forecastState.value = ForecastUiState.Success(result.data)
                }

                is Result.Error -> {
                    _forecastState.value = ForecastUiState.Error(
                        result.exception.message ?: "Unknown error occurred"
                    )
                }
                is Result.Loading -> {
                    // TODO handle loading state
                }
            }
        }
    }

    fun rerfresh() {
        _selectedCity.value?.let { city ->
            loadWeather(city, forceRefresh = true)
            loadForecast(city, forceRefresh = true)
        }
    }















}