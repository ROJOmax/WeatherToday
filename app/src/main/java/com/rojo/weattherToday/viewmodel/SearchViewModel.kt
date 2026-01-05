package com.rojo.weattherToday.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _recentSearches = MutableStateFlow<List<String>>(emptyList())
    val recentSearches: StateFlow<List<String>> = _recentSearches.asStateFlow()

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun addToRecentSearches(cityName: String) {
        viewModelScope.launch {
            val currentList = _recentSearches.value.toMutableList()
            // if already exists remove
            currentList.remove(cityName)
            // add to top
            currentList.add(0, cityName)
            // keep onlyy last 10
            if (currentList.size > 10) {
                currentList.removeAt(currentList.size - 1)
            }
            _recentSearches.value = currentList
        }
    }

    fun clearSearchQuery() {
        _searchQuery.value = ""
    }
}