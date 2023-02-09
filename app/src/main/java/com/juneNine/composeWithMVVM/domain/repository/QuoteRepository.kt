package com.juneNine.composeWithMVVM.domain.repository

interface QuoteRepository {
    suspend fun getRandomQuote()
}