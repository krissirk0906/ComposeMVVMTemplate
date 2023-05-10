package com.junenine.mvvmcompose.domain.repository

import com.junenine.mvvmcompose.data.model.SampleResponse
import com.junenine.mvvmcompose.data.model.Weather

interface MyRepository {
    suspend fun myNetworkCall() : SampleResponse?
    suspend fun getWeather(key : String, q: String, day : Int) : Weather?
}