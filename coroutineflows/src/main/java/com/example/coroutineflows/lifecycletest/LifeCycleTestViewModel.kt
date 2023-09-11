package com.example.coroutineflows.lifecycletest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LifeCycleTestViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<Int>>(UiState.Loading)

    val uiState: StateFlow<UiState<Int>> = _uiState

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = UiState.Loading
            delay(1000L)
            _uiState.value=UiState.Success(10)
            delay(10000L)
            _uiState.value=UiState.Error("Checking Error")


        }
    }

}