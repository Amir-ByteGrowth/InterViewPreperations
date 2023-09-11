package com.example.coroutineflows

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

object HotVsColdFlow {
    //hot flow
    val sharedFlow = MutableSharedFlow<Int>(5 )

    fun getValuesFromSharedFlow() {
        GlobalScope.launch {
            sharedFlow.emit(1)
            sharedFlow.emit(2)
            sharedFlow.emit(3)
            sharedFlow.emit(4)
            sharedFlow.emit(5)

        }


        GlobalScope.launch {
            delay(5000L)
            sharedFlow.collect {
                Log.d("SharedFlow1", it.toString())
            }
//            delay(1000)


        }

        GlobalScope.launch {
            delay(5000L)
            sharedFlow.collect {
                Log.d("SharedFlow2", it.toString())
            }
        }


    }

    val stateFlow = MutableStateFlow(-1)

    fun getValueFromStateFlow() {

        GlobalScope.launch {
            stateFlow.emit(1)
            delay(1000L)
            stateFlow.emit(2)
            stateFlow.emit(3)
            delay(1000L)
            stateFlow.emit(4)
            stateFlow.emit(5)
        }

        GlobalScope.launch {
            delay(5000L)
            stateFlow.collect {
                Log.d("StateFlow", it.toString())
            }
        }
    }

}