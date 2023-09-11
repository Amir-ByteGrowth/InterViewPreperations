package com.example.coroutineflows.livedatavsflows

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LiveDataViewModel : ViewModel() {
    // Create a LiveData with a String
    val status: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    // Rest of the ViewModel...
    val timerUpdate: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val counter = object : CountDownTimer(6000, 1000) {
        override fun onTick(p0: Long) {
            timerUpdate.value = "${p0 / 1000}"
        }

        override fun onFinish() {
            timerUpdate.value = "Resend OTP"
        }
    }

    ////flow
    val flowTimer : Flow<String> = flow {
        for (i in 1..60){
            emit(""+i)
            delay(1000)
        }
        emit("Resend OTP")
    }


}