package com.hehc.roomsample.ui.homescreen

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


    fun getStarships(ids: List<Int>) {
        val starships: MutableList<Starship> = mutableListOf()
        viewModelScope.launch {
            for (id in ids) {
                try {
                    val starship = repo.getStarship(id.toString())
                    starships.add(starship)
                } catch (e: Exception){

                }
            }
            _ships.value = starships
        }

    }
}