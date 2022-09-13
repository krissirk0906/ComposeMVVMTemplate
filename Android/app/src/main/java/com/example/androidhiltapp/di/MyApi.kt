package com.example.androidhiltapp.di

import com.example.androidhiltapp.data.model.SampleResponse
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {
    @GET("random")
    suspend fun doNetworkCall() : Response<SampleResponse?>
}