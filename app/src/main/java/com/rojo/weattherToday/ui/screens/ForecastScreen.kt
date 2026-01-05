package com.rojo.weattherToday.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
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
import coil.compose.AsyncImage
import com.rojo.weattherToday.data.local.ForecastEntity
import com.rojo.weattherToday.data.model.ForecastItem
import com.rojo.weattherToday.viewmodel.ForecastUiState
import com.rojo.weattherToday.viewmodel.WeatherViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForecastScreenContent(
    cityName: String,
    weatherViewModel: WeatherViewModel,
    onBackClick: () -> Unit
) {
    val forecastState by weatherViewModel.forecastState.collectAsState()

    // load forecast on screen open
    LaunchedEffect(cityName) {
        weatherViewModel.loadForecast(cityName)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("5-Day Forecast") },
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
            when (val state = forecastState) {
                is ForecastUiState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is ForecastUiState.Success -> {
                    ForecastList(
                        forecasts = state.forecasts,
                        cityName = cityName
                    )
                }

                is ForecastUiState.Error -> {
                    ErrorContent(
                        message = state.message,
                        onRetry = { weatherViewModel.loadForecast(cityName) }
                    )
                }

                is ForecastUiState.Initial -> {
                    // TODO handle this
                }
            }
        }
    }
}


@Composable
fun ForecastList(
    forecasts: List<ForecastEntity>,
    cityName: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = cityName,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // forecastlist
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(forecasts) {forecast ->
                //TODO replace import
                ForecastItem(forecast = forecast)
            }
        }
    }
}

@Composable
fun ForecastItem(forecast: ForecastEntity) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Date and Time Column
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = formatForecastDate(forecast.dateTimeText),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = formatForecastTime(forecast.dateTimeText),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Weather Icon
            AsyncImage(
                model = "https://openweathermap.org/img/wn/${forecast.weatherIcon}@2x.png",
                contentDescription = "Weather icon",
                modifier = Modifier.size(48.dp)
            )

            // Weather Info Column
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "${forecast.temperature.toInt()}°C",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = forecast.weatherDescription.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
                    },
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                // Show probability of precipitation if > 0
                if (forecast.probabilityOfPrecipitation > 0) {
                    Text(
                        text = "Rain: ${(forecast.probabilityOfPrecipitation * 100).toInt()}%",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

private fun formatForecastTime(dateTimeText: String): String {
    return try {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = sdf.parse(dateTimeText)
        val outputSdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        outputSdf.format(date ?: Date())
    } catch (e: Exception) {
        dateTimeText
    }
}

private fun formatForecastDate(dateTimeText: String): String {
    return try {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = sdf.parse(dateTimeText)
        val outputSdf = SimpleDateFormat("EEE, MMM dd", Locale.getDefault())
        outputSdf.format(date ?: Date())
    } catch (e: Exception) {
        dateTimeText
    }
}