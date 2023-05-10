package com.junenine.mvvmcompose.domain.repository

import android.app.Application
import com.junenine.mvvmcompose.R
import com.junenine.mvvmcompose.data.model.SampleResponse
import com.junenine.mvvmcompose.data.model.Weather
import com.junenine.mvvmcompose.di.MyApi
import javax.inject.Inject

class MyRepositoryImplement @Inject constructor(private val api: MyApi, private val app: Application) :
    MyRepository {
    init {
        println("MyRepositoryImplement " + app.applicationContext.getString(R.string.app_name))
    }

    override suspend fun myNetworkCall(): SampleResponse? {
        val result = api.doNetworkCall()
        return result.body()
    }

    override suspend fun getWeather(key: String, q: String, day: Int): Weather? {
        val result = api.getWeather(key, q, day)
        return result.body()
    }
}