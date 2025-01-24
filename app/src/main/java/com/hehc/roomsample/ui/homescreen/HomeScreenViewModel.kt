package com.hehc.roomsample.ui.homescreen

import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hehc.roomsample.persistance.Starship
import com.hehc.roomsample.repository.StarshipRepository
import com.hehc.roomsample.repository.StarshipRepositoryContract
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val repo: StarshipRepositoryContract = StarshipRepository()
) : ViewModel() {


    private val _ships = MutableStateFlow<List<Starship>>(listOf())
    val ships: StateFlow<List<Starship>> = _ships

    fun getStarships() {
        val starships: MutableList<Starship> = mutableListOf()
        viewModelScope.launch {
            try {
                val starship = repo.getAllStarships()
                starships.addAll(starship)
                _ships.value = starships
            } catch (e: Exception) {
                _ships.value = listOf()
            }
        }
    }

    fun saveStarship(ship: Starship) {
        viewModelScope.launch {
            try {
                repo.saveStarship(ship)
            } catch (e: SQLiteConstraintException) {
                Log.d("ViewModel", "Error adding duplicate ship: ${ship.name}")
            }
        }
    }
}