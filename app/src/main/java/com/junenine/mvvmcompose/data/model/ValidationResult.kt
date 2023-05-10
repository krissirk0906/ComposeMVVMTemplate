package com.junenine.composeWithMVVM.data.model

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: UiText? = null
)