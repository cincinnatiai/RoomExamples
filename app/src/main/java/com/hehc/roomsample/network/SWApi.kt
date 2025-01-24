package com.hehc.roomsample.network

import retrofit2.http.GET

interface SWApi {
    @GET("starships/")
    suspend fun getAllStarships(): SWApiResponse
}
