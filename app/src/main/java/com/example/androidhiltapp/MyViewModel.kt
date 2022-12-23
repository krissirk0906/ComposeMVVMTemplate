package com.example.androidhiltapp

import android.util.Log
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhiltapp.data.model.SampleResponse
import com.example.androidhiltapp.di.MyApi
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: Lazy<MyRepository>,
    private val userRepository: Lazy<UserRepository>
) : ViewModel() {
    private val _quote = MutableLiveData<SampleResponse?>()
    val quote: LiveData<SampleResponse?>
        get() = _quote

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _calculateResult = MutableStateFlow("")
    val calculateResult = _calculateResult.asStateFlow()

    init {
        _isLoading.value = false
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = repository.get().getWeather(MyApi.weatherApiKey, "Hanoi", 1)
            Log.d("MyViewModel", "getWeather: $result")
            _calculateResult.value = result.toString()
            _isLoading.value = false
        }
    }

    fun callRepo() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            try {
                _quote.postValue(repository.get().myNetworkCall())
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    fun calCalculate(value: TextFieldValue) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            try {
                _calculateResult.value =
                    userRepository.get().calculate(value.text)?.result ?: "No answer"
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.postValue(false)
            }
        }
    }
}