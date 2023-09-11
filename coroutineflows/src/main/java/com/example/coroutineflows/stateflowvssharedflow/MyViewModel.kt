package com.example.coroutineflows.stateflowvssharedflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyViewModel :ViewModel() {
    val _myStateFlow= MutableStateFlow(0)
    val myStateFlow: StateFlow<Int>
        get() = _myStateFlow

    val mySharedFlow= MutableSharedFlow<Int>(replay = 5)


    fun setMyStateFlowValues(){
        _myStateFlow.value = 1

        _myStateFlow.value = 2

        _myStateFlow.value = 2

        _myStateFlow.value = 1

        _myStateFlow.value = 3
    }


    fun setMySharedValue(){
        GlobalScope.launch {
            mySharedFlow.emit(10)
            mySharedFlow.emit(11)
            mySharedFlow.emit(12)
            mySharedFlow.emit(13)
            mySharedFlow.emit(14)
            mySharedFlow.emit(15)
        }

    }



}