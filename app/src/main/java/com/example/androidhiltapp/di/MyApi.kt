package com.example.androidhiltapp.di

import com.example.androidhiltapp.data.model.MathResponse
import com.example.androidhiltapp.data.model.SampleResponse
import com.example.androidhiltapp.data.model.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MyApi {
    companion object {
        const val apiKey = "RGAPI-ac85c11d-9491-4b96-8805-f641250ecf0c"
        const val weatherApiKey = "f24fe42c15b34dff88094624222312"
    }

    @GET("random")
    suspend fun doNetworkCall(): Response<SampleResponse?>

    @GET
    suspend fun getMathEqual(@Url url: String): Response<MathResponse?>

    @GET("https://api.weatherapi.com/v1/forecast.json")
    suspend fun getWeather(
        @Query("key") key: String,
        @Query("q") q: String,
        @Query("days") days: Int
    ): Response<Weather?>
}