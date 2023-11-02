package com.junenine.composeTemplate.domain.repository

import com.junenine.composeTemplate.data.model.MathResponse

interface MathRepository {
    suspend fun calculate(math: String): MathResponse?
}