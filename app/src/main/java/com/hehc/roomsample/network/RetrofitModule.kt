package com.hehc.roomsample.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

    private const val BASE_URL = "https://swapi.dev/api/"


    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
//        return OkHttpClient.Builder().addInterceptor(getLoggingInterceptor()).build()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().client(getOkHttpClient()).baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun createSWApi(): SWApi = getRetrofit().create(SWApi::class.java)

}
