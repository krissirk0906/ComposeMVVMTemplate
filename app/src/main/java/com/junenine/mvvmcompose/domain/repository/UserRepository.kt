package com.junenine.mvvmcompose.domain.repository

import com.junenine.mvvmcompose.data.model.MathResponse

interface UserRepository {
    suspend fun calculate(math: String): MathResponse?
}