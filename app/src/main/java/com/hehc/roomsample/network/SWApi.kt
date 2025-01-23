package com.hehc.roomsample.network

import com.hehc.roomsample.persistance.Starship
import retrofit2.http.GET
import retrofit2.http.Path

interface SWApi {

    @GET("starships/{id}/")
    suspend fun getStarship(
        @Path("id") id:String
    ): Starship

}
