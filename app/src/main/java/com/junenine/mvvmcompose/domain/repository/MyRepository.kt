package com.junenine.composeWithMVVM.domain.repository

import com.junenine.composeWithMVVM.data.model.SampleResponse
import com.junenine.composeWithMVVM.data.model.Weather

interface MyRepository {
    suspend fun myNetworkCall() : SampleResponse?
    suspend fun getWeather(key : String, q: String, day : Int) : Weather?
}