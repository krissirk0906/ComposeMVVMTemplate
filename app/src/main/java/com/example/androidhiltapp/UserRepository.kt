package com.example.androidhiltapp

import com.example.androidhiltapp.data.model.MathResponse

interface UserRepository {
    suspend fun calculate(math: String): MathResponse?
}