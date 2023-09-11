package com.example.coroutineflows

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.retryWhen
import kotlinx.coroutines.launch
import java.io.IOException

object RetryAndRetryWhen {
    val simpleFlow = flowOf(1, 2, 3, 4, 5)

    fun retryFun() {
        simpleFlow.retryWhen { cause, attempt ->

            return@retryWhen cause == IOException() && attempt < 3

        }

        GlobalScope.launch {
            doLongRunningTask().catch {
                Log.d("IO Exception",it.toString())
            }.retryWhen { cause, attempt ->
                return@retryWhen cause == IOException() && attempt<3

            }.collect {
                Log.d("Retry Tried", it.toString())
            }
        }

    }


    fun doLongRunningTask(): Flow<Int> {
        return flow {
            // your code for doing a long running task
            // Added delay, random number, and exception to simulate
            delay(2000)
            var randomNumber = (0..2).random()
            randomNumber=0
            if (randomNumber == 0) {
                throw IOException("AMir")
            } else if (randomNumber == 1) {
                throw IndexOutOfBoundsException()
            }
            randomNumber=3
//            delay(2000)
            emit(randomNumber)
        }
    }
}