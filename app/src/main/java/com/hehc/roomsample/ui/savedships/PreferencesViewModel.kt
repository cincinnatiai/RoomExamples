package com.hehc.roomsample.ui.savedships

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hehc.roomsample.persistance.Starship
import com.hehc.roomsample.repository.StarshipRepository
import com.hehc.roomsample.repository.StarshipRepositoryContract
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PreferencesViewModel(
    private val repo: StarshipRepositoryContract = StarshipRepository()
) : ViewModel() {

    private val _preferences = MutableStateFlow<List<Starship>>(listOf())
    val preferences: StateFlow<List<Starship>> = _preferences

    fun getPreferences() {
        viewModelScope.launch {
            try {
                _preferences.value = repo.getAllFavorites()
            } catch (e: Exception) {
                Log.d("ViewModel", "Error loading favorites")
                _preferences.value = listOf()
            }
        }
    }
}
