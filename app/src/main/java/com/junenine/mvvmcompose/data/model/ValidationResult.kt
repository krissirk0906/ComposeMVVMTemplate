package com.junenine.mvvmcompose.data.model

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: UiText? = null
)