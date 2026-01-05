package com.rojo.weattherToday.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.rojo.weattherToday.ui.screens.CurrentWeatherScreenContent
import com.rojo.weattherToday.ui.screens.ForecastScreenContent
import com.rojo.weattherToday.ui.screens.SearchScreenContent
import com.rojo.weattherToday.viewmodel.SearchViewModel
import com.rojo.weattherToday.viewmodel.WeatherViewModel

@Composable
fun WeatherNavigation() {

    val backStack: SnapshotStateList<Any> = remember {
        mutableStateListOf(SearchKey)
    }

    NavDisplay(
        backStack = backStack,
        entryProvider = { key ->
            when (key) {
                is SearchKey -> {
                    NavEntry(key) {
                        val searchViewModel: SearchViewModel = hiltViewModel()

                        SearchScreenContent(
                            searchViewModel = searchViewModel,
                            onCitySelected = { cityName ->
                                searchViewModel.addToRecentSearches(cityName)
                                backStack.add(CurrentWeatherkey(cityName))
                            }
                        )
                    }
                }

                is CurrentWeatherkey -> {
                    NavEntry(key) {
                        val weatherViewModel: WeatherViewModel = hiltViewModel()

                        CurrentWeatherScreenContent(
                            cityName = key.cityName,
                            weatherViewModel = weatherViewModel,
                            onBackClick = {
                                backStack.removeLast()
                            },
                            onViewForecastClick = { cityName ->
                                backStack.add(ForecastKey(cityName))
                            }
                        )
                    }
                }

                is ForecastKey -> {
                    NavEntry(key) {
                        val weatherViewModel: WeatherViewModel = hiltViewModel()

                        ForecastScreenContent(
                            cityName = key.cityName,
                            weatherViewModel = weatherViewModel,
                            onBackClick = {
                                backStack.removeLast()
                            }
                        )
                    }
                }

                else -> error("Unknown navigation key: $key")
            }
        }
    )
}
