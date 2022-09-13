package com.example.androidhiltapp

import com.example.androidhiltapp.data.model.SampleResponse

interface MyRepository {
    suspend fun myNetworkCall() : SampleResponse?
}