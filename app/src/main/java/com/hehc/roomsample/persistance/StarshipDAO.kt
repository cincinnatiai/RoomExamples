package com.hehc.roomsample.persistance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StarshipDAO {

    @Query("SELECT * FROM starship")
    fun getAll(): List<Starship>

    @Insert
    fun insertAll(vararg starships: Starship)
}