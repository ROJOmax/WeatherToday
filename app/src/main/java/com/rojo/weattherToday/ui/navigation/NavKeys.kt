package com.rojo.weattherToday.ui.navigation

import androidx.compose.runtime.Immutable
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Immutable
@Serializable
object SearchKey : NavKey

@Immutable
@Serializable
data class CurrentWeatherkey(val cityName: String): NavKey

@Immutable
@Serializable
data class ForecastKey(val cityName: String) : NavKey