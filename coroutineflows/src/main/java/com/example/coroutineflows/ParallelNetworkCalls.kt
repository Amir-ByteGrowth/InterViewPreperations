package com.example.coroutineflows

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

class ParallelNetworkCalls : ViewModel() {

    var netwrokCall1 = flow<Int> {
        Log.d("FirstNetworkCall","InProgress")
        delay(5000L)
        emit(10)
        Log.d("FirstNetworkCall","Done")
    }

    var netwrokCall2 = flow<Int> {
        Log.d("SecondNetworkCall","InProgress")
        delay(10000L)
        emit(10)
        Log.d("SecondNetworkCall","Done")
    }

    fun combineTwoNetworkCalls() {
        viewModelScope.launch {
            netwrokCall1
                .zip(netwrokCall2) { resultOne, resultTwo ->
                    return@zip resultOne + resultTwo
                }
                .flowOn(Dispatchers.Default)
                .catch { e ->
                    // handle exception
                }
                .collect {
                    Log.d("ResultOfTwoApiCalls", it.toString())
                }
        }
    }


}