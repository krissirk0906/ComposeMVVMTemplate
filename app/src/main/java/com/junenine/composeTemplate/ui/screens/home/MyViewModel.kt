package com.junenine.composeTemplate.ui.screens.home

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junenine.composeTemplate.domain.repository.MathRepository
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val mathRepository: Lazy<MathRepository>
) : ViewModel() {
    private val _calculateResult = MutableStateFlow("")
    val calculateResult = _calculateResult.asStateFlow()

    fun calCalculate(value: TextFieldValue) {
        viewModelScope.launch {
            try {
                _calculateResult.value =
                    mathRepository.get().calculate(value.text)?.result ?: "No answer"
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}