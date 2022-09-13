package com.example.androidhiltapp

import android.app.Application
import com.example.androidhiltapp.data.model.SampleResponse
import com.example.androidhiltapp.di.MyApi

class MyRepositoryImplement(private val api: MyApi, private val app: Application) : MyRepository {
    init {
        println("MyRepositoryImplement " + app.applicationContext.getString(R.string.app_name))
    }

    override suspend fun myNetworkCall(): SampleResponse? {
        val result = api.doNetworkCall()
        return result.body()
    }
}