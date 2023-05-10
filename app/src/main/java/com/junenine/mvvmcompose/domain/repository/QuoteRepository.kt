package com.junenine.composeWithMVVM.domain.repository

interface QuoteRepository {
    suspend fun getRandomQuote()
}