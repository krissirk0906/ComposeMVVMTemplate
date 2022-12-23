package com.example.androidhiltapp.domain.repository

interface QuoteRepository {
    suspend fun getRandomQuote()
}