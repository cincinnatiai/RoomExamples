package com.hehc.roomsample.di

import android.content.Context
import androidx.room.Room
import com.hehc.roomsample.network.SWApi
import com.hehc.roomsample.persistance.StarshipDAO
import com.hehc.roomsample.persistance.StarshipDataBase

object DependencyInjectionModule {

    private const val DATABASE_NAME = "starship-database"

    fun initialize(context: Context) {
        val db = Room.databaseBuilder(context, StarshipDataBase::class.java, DATABASE_NAME).build()
        dao = db.getDao()
    }

    private val retrofitModule = RetrofitModule()
    val api: SWApi = retrofitModule.createSWApi()
    lateinit var dao: StarshipDAO
}