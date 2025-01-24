package com.hehc.roomsample.repository

import android.util.Log
import com.hehc.roomsample.di.DependencyInjectionModule.api
import com.hehc.roomsample.di.DependencyInjectionModule.dao
import com.hehc.roomsample.network.SWApi
import com.hehc.roomsample.persistance.Starship
import com.hehc.roomsample.persistance.StarshipDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StarshipRepository(
    private val remoteSource: SWApi = api,
    private val localSource: StarshipDAO = dao
) : StarshipRepositoryContract {

    override suspend fun getAllStarships(): List<Starship> {
        return withContext(Dispatchers.IO) {
            return@withContext remoteSource.getAllStarships().results
        }
    }

    override suspend fun saveStarship(ship: Starship) {
        withContext(Dispatchers.IO) {
            Log.d("Repo", "Saving ship: ${ship.name}")
            localSource.insertAll(ship)
        }
    }

    override suspend fun getAllFavorites(): List<Starship> {
       return withContext(Dispatchers.IO){
            Log.d("Repo","Extracting favorite ships.")
            return@withContext localSource.getAll()
        }
    }
}
