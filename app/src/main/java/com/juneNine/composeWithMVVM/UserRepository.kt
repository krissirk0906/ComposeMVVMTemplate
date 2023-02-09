package com.juneNine.composeWithMVVM

import com.juneNine.composeWithMVVM.data.model.MathResponse

interface UserRepository {
    suspend fun calculate(math: String): MathResponse?
}