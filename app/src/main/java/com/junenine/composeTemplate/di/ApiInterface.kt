package com.junenine.composeTemplate.di

import com.junenine.composeTemplate.data.model.MathResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {
    @GET
    suspend fun getMathEqual(@Url url: String): Response<MathResponse?>
}