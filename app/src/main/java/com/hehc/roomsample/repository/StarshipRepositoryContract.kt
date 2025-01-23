package com.hehc.roomsample.repository

import com.hehc.roomsample.persistance.Starship

interface StarshipRepositoryContract {
    suspend fun getStarship(
        id: String
    ): Starship
}

