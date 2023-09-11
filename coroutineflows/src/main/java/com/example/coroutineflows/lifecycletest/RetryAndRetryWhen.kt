package com.example.coroutineflows.lifecycletest

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

object RetryAndRetryWhen {
     fun doLongRunningTask(): Flow<Int> {
        return flow {
            // your code for doing a long running task
            // Added delay, random number, and exception to simulate
            delay(2000)
            val randomNumber = (0..10).random()
            if (randomNumber in 0..9) {
                throw IOException()
            } else if (randomNumber == 1) {
                throw IndexOutOfBoundsException()
            }
            delay(2000)
            emit(randomNumber)
        }
    }
}