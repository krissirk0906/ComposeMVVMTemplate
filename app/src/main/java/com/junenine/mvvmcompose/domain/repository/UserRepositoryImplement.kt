package com.junenine.mvvmcompose.domain.repository

import android.app.Application
import com.junenine.mvvmcompose.data.model.MathResponse
import com.junenine.mvvmcompose.di.MyApi
import javax.inject.Inject

class UserRepositoryImplement @Inject constructor(private val api: MyApi, app: Application) :
    UserRepository {
    override suspend fun calculate(math : String): MathResponse? {
        val result = api.getMathEqual("https://newton.vercel.app/api/v2/factor/${math}")
        return result.body()
    }
}