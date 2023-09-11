package com.example.coroutineflows.lifecycletest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutineflows.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.flow.retryWhen
import kotlinx.coroutines.launch
import java.io.IOException

class RetryAndRetryWhenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retry_and_retry_when)

        GlobalScope.launch {
            RetryAndRetryWhen.doLongRunningTask()
                .flowOn(Dispatchers.Default)
                .retry(retries = 5) { cause ->
                    Log.d("RetriesChecking", "Checking")
                    if (cause is IOException || cause is IndexOutOfBoundsException) {
                        delay(2000)
                        return@retry true
                    } else {
                        return@retry false
                    }
                }
                .catch {
                    Log.d("ExceptionHere", "Occured  " + it.message + "\n" + it.toString())
                }
                .collect {
                    // success
                    Log.d("SuccessFlow", it.toString() + " Data ")
                }
        }

    }


    fun retryWhenTest() {
        GlobalScope.launch {
            RetryAndRetryWhen.doLongRunningTask()
                .flowOn(Dispatchers.Default)
                .retryWhen { cause, attempt ->
                    if (cause is IOException && attempt < 3) {
                        delay(2000)
                        return@retryWhen true
                    } else {
                        return@retryWhen false
                    }
                }
                .catch {
                    // error
                }
                .collect {
                    // success
                }
        }
    }

}