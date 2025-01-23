package com.hehc.roomsample.repository

import com.hehc.roomsample.network.RetrofitModule
import com.hehc.roomsample.persistance.Starship
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StarshipRepository: StarshipRepositoryContract {

    private val api = RetrofitModule.createSWApi()

    override suspend fun getStarship(id: String): Starship {
        return withContext(Dispatchers.IO) {
            return@withContext api.getStarship(id)
        }
    }


}
