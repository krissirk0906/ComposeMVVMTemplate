package com.junenine.composeWithMVVM.ui.components.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.junenine.composeWithMVVM.data.model.PopupModel
import com.junenine.composeWithMVVM.data.model.UiText
import com.junenine.composeWithMVVM.domain.use_case.ValidateEmailUseCase
import com.junenine.composeWithMVVM.domain.use_case.ValidatePasswordUseCase

class MainViewModel : ViewModel() {

    private val validateEmailUseCase = ValidateEmailUseCase()
    private val validatePasswordUseCase = ValidatePasswordUseCase()

    var formState by mutableStateOf(MainState())

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.EmailChanged -> {
                formState = formState.copy(email = event.email)
                validateEmail()
            }

            is MainEvent.PasswordChanged -> {
                formState = formState.copy(password = event.password)
                validatePassword()
            }

            is MainEvent.VisiblePassword -> {
                formState = formState.copy(isVisiblePassword = event.isVisiblePassword)
            }

            is MainEvent.Submit -> {
                if (validateEmail() && validatePassword()) {
                    formState = formState.copy(popup = PopupModel("Welcome back","You have login success"))
                }
            }
            is MainEvent.ClickPopUp -> {
                formState =  formState.copy(popup = null)
            }
        }
    }

    private fun validateEmail(): Boolean {
        val emailResult = validateEmailUseCase.execute(formState.email)
        formState = formState.copy(emailError = emailResult.errorMessage)
        return emailResult.successful
    }

    private fun validatePassword(): Boolean {
        val passwordResult = validatePasswordUseCase.execute(formState.password)
        formState = formState.copy(passwordError = passwordResult.errorMessage)
        return passwordResult.successful
    }
}

sealed class MainEvent {
    data class EmailChanged(val email: String) : MainEvent()
    data class PasswordChanged(val password: String) : MainEvent()
    data class VisiblePassword(val isVisiblePassword: Boolean) : MainEvent()
    object Submit : MainEvent()
    data class ClickPopUp(val action : Int) : MainEvent()
}

data class MainState(
    val email: String = "",
    val emailError: UiText? = null,
    val password: String = "",
    val passwordError: UiText? = null,
    val isVisiblePassword: Boolean = false,
    val popup : PopupModel? = null
)