package com.junenine.mvvmcompose.domain.use_case

import com.junenine.mvvmcompose.R
import com.junenine.mvvmcompose.data.model.UiText
import com.junenine.mvvmcompose.data.model.ValidationResult
import com.junenine.mvvmcompose.utils.ValidationUtils.isNumber

class ValidatePhoneNumberUseCase : BaseUseCase<String, ValidationResult> {

    override fun execute(input: String): ValidationResult {
        if (input.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strThePhoneCanNotBeBlank),
            )
        }

        if (!isNumber(input)) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strThePhoneNumberShouldBeContentJustDigit),
            )
        }

        return ValidationResult(
            successful = true,
            errorMessage = null
        )
    }
}