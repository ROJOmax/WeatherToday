package com.rojo.weattherToday.ui.screens

import android.text.Layout
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.rojo.weattherToday.data.local.WeatherEntity
import com.rojo.weattherToday.data.model.Weather
import com.rojo.weattherToday.viewmodel.WeatherUiState
import com.rojo.weattherToday.viewmodel.WeatherViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrentWeatherScreenContent(
    cityName: String,
    weatherViewModel: WeatherViewModel,
    onBackClick: () -> Unit,
    onViewForecastClick: (String) -> Unit
) {
    val weatherState by weatherViewModel.weatherState.collectAsState()

    // load weather when screen opens
    LaunchedEffect(cityName) {
        weatherViewModel.loadWeather(cityName)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Current Weather") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { weatherViewModel.rerfresh() }) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Refresh"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (val state = weatherState) {
                is WeatherUiState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                is WeatherUiState.Success -> {
                    WeatherConctent(
                        weather = state.weather,
                        onViewForecastClick = { onViewForecastClick(cityName) }
                    )
                }
                is WeatherUiState.Error -> {
                    ErrorContent(
                        message = state.message,
                        onRetry = { weatherViewModel.loadWeather(cityName)}
                    )
                }
                is WeatherUiState.Initial -> {
                    // TODO handle this
                }
            }
        }
    }
}

@Composable fun WeatherConctent(weather: WeatherEntity, onViewForecastClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // city name and countryy
        Text(
            text = "${weather.cityName}, ${weather.country}",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        // weather icon
        AsyncImage(
            model = "https://openweathermap.org/img/wn/${weather.weatherIcon}@4x.png",
            contentDescription = "Weather Icon",
            modifier = Modifier.height(120.dp)
        )

        /// temperature
        Text(
            text = weather.weatherDescription.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
            },
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(32.dp))
        // weather details card
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                WeatherDetailRow("Feels Like", "${weather.feelsLike.toInt()}°C")
                WeatherDetailRow("Min / Max", "${weather.tempMin.toInt()}°C / ${weather.tempMax.toInt()}°C")
                WeatherDetailRow("Humidity", "${weather.pressure}%")
                WeatherDetailRow("Pressure", "${weather.pressure}hPa")
                WeatherDetailRow("Wind Speed", "${weather.windSpeed} m/s")
                WeatherDetailRow("Cloudiness", "${weather.cloudiness}%")

                val sunriseTime = formatTime(weather.sunrise)
                val sunsetTime = formatTime(weather.sunset)

                WeatherDetailRow("Sunrise", sunriseTime)
                WeatherDetailRow("Sunset", sunsetTime)

            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // view forecast button
        Button(
            onClick = onViewForecastClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View 5-Day Forecast")
        }
    }
}



@Composable
fun ErrorContent(
    message: String,
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "⚠️",
            fontSize = 48.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Error",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.error,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = onRetry) {
            Text("Retry")
        }
    }
}

@Composable
fun WeatherDetailRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold
        )
    }
}



private fun formatTime(timestamp: Long): String {
    val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
    return sdf.format((Date(timestamp * 1000)))
}







































