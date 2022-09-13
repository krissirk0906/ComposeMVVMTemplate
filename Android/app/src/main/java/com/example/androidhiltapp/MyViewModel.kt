package com.example.androidhiltapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhiltapp.data.model.SampleResponse
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: Lazy<MyRepository>) : ViewModel() {
    private val _quote = MutableLiveData<SampleResponse?>()
    val quote: LiveData<SampleResponse?>
        get() = _quote

    fun callRepo() {
        viewModelScope.launch {
           val k =  repository.get().myNetworkCall()
            _quote.postValue(k)
            println(k.toString())
        }
    }
}