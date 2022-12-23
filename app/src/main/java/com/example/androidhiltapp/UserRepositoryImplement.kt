package com.example.androidhiltapp

import android.app.Application
import com.example.androidhiltapp.data.model.MathResponse
import com.example.androidhiltapp.di.MyApi
import kotlinx.coroutines.delay
import javax.inject.Inject

class UserRepositoryImplement @Inject constructor(private val api: MyApi, app: Application) :
    UserRepository {
    override suspend fun calculate(math : String): MathResponse? {
        val result = api.getMathEqual("https://newton.vercel.app/api/v2/factor/${math}")
        return result.body()
    }
}