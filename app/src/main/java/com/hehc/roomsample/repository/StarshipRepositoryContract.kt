package com.hehc.roomsample.repository

import com.hehc.roomsample.persistance.Starship

interface StarshipRepositoryContract {
    suspend fun getAllStarships(): List<Starship>
    suspend fun saveStarship(ship: Starship)
}

