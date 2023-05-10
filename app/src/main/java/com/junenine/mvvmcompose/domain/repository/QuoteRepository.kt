package com.junenine.mvvmcompose.domain.repository

interface QuoteRepository {
    suspend fun getRandomQuote()
}