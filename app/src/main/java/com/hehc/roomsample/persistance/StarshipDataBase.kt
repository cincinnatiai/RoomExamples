package com.hehc.roomsample.persistance

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Starship::class],version = 1)
abstract class StarshipDataBase : RoomDatabase() {
    abstract fun getDao(): StarshipDAO
}
