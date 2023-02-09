package com.juneNine.composeWithMVVM

import com.juneNine.composeWithMVVM.data.model.SampleResponse
import com.juneNine.composeWithMVVM.data.model.Weather

interface MyRepository {
    suspend fun myNetworkCall() : SampleResponse?
    suspend fun getWeather(key : String, q: String, day : Int) : Weather?
}