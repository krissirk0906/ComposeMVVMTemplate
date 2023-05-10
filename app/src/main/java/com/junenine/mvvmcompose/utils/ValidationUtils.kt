package com.junenine.mvvmcompose.utils

import android.util.Patterns

object ValidationUtils {
    fun isNumber(value: String): Boolean {
        return value.isEmpty() || Regex("^\\d+\$").matches(value)
    }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isPasswordValid(password: String): Boolean {
        return password.any { it.isDigit() } &&
                password.any { it.isLetter() }
    }
}