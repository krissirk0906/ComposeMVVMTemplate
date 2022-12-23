package com.example.androidhiltapp

import com.example.androidhiltapp.data.model.SampleResponse
import com.example.androidhiltapp.data.model.Weather

interface MyRepository {
    suspend fun myNetworkCall() : SampleResponse?
    suspend fun getWeather(key : String, q: String, day : Int) : Weather?
}