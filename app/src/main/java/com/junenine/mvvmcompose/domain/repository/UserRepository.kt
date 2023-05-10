package com.junenine.composeWithMVVM.domain.repository

import com.junenine.composeWithMVVM.data.model.MathResponse

interface UserRepository {
    suspend fun calculate(math: String): MathResponse?
}