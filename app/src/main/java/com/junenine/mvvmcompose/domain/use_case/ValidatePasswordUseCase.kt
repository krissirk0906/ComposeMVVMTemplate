package com.junenine.mvvmcompose.domain.use_case

import com.junenine.mvvmcompose.R
import com.junenine.mvvmcompose.data.model.UiText
import com.junenine.mvvmcompose.data.model.ValidationResult
import com.junenine.mvvmcompose.utils.ValidationUtils.isPasswordValid

class ValidatePasswordUseCase : BaseUseCase<String, ValidationResult> {
    override fun execute(input: String): ValidationResult {
        if (input.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strThePasswordNeedsToConsistOfAtLeastEightCharacters),
            )
        }

        if (!isPasswordValid(input)) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.strThePasswordNeedsToContainAtLeastOneLetterAndDigit),
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}