package com.juneNine.composeWithMVVM.utils

import java.util.*

object Utils {

    fun Double?.toCurrency(): String {
        return "$this ${getCurrentCurrency()}"
    }

    fun getCurrentCurrency(): String {
        val locale = Locale.getDefault()

// Get the user's currency
        val currency = Currency.getInstance(locale)

// Get the currency code (e.g. "USD", "EUR", etc.)
        val currencyCode = currency.currencyCode

// Get the currency symbol (e.g. "$", "€", etc.)
        return currency.symbol
    }

    fun Double.isPositive(): Boolean {
        return this >= 0
    }
}