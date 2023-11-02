package com.junenine.composeTemplate.data.repository

import com.junenine.composeTemplate.data.model.MathResponse
import com.junenine.composeTemplate.di.ApiInterface
import com.junenine.composeTemplate.domain.repository.MathRepository
import javax.inject.Inject

class MathRepositoryImplement @Inject constructor(private val api: ApiInterface) :
    MathRepository {
    override suspend fun calculate(math : String): MathResponse? {
        val result = api.getMathEqual("https://newton.vercel.app/api/v2/factor/${math}")
        return result.body()
    }
}