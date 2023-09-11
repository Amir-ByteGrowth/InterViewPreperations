package com.example.solidprinciples

import android.util.Log
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

object ParallelCoroutines {

    fun parallelCall() {
        GlobalScope.launch {
            launch {
                delay(5000L)
                Log.d("ParallelCoroutines", "5 Sec")
            }
            launch {
                delay(10000L)
                Log.d("ParallelCoroutines", "10 Sec")
            }
            launch {
                delay(15000L)
                Log.d("ParallelCoroutines", "15 Sec")
            }
        }
    }

    fun waitForCompletionCall() {
        GlobalScope.launch {
            var job1 = launch {
                delay(5000L)
                Log.d("ParallelCoroutines", "5 Sec")
            }
            var job2 = launch {
                delay(10000L)
                Log.d("ParallelCoroutines", "10 Sec")
            }
            var job3 = launch {
                delay(15000L)
                Log.d("ParallelCoroutines", "15 Sec")
            }

            job1.join()
            job2.join()
            job3.join()

            Log.d("WaitForCompletion", "All jobs Done")

        }
    }


    fun startCoroutingUsingAsynch() {
        GlobalScope.async {
            var job1 = async {
                delay(5000L)
                Log.d("ParallelCoroutinesAsynch", "5 Sec")
            }
            var job2 = async {
                delay(10000L)
                Log.d("ParallelCoroutinesAsycnh", "10 Sec")
            }
            var job3 = async {
                delay(15000L)
                Log.d("ParallelCoroutinesAsynch", "15 Sec")
            }

            job1.join()
            job2.join()
            job3.join()

            Log.d("WaitForCompletionAsynch", "All jobs Done")
        }
    }


    fun exceptionHandlingInLaunch() {

        GlobalScope.launch {
            try {
                MainActivity().doSomethingAndThrowException()
            } catch (exception: Exception) {
                Log.d("LaunchException", exception.toString())
            }

        }
    }

    val handler = CoroutineExceptionHandler { _, exception ->
        Log.d("LaunchExceptionHandler", exception.message.toString())
    }

    fun exceptionHandlingInLaunchUsingHandler() {

        GlobalScope.launch(handler) {
            MainActivity().doSomethingAndThrowException()

        }
    }


    fun multipleExceptionHandling() {
        GlobalScope.async {
            try {
                Log.d("FirstJob", "Done")
                MainActivity().doSomethingAndThrowException()
            } catch (exception: Exception) {
                Log.d("MultipleException1", exception.toString())
            }
            try {
                Log.d("SecondJob", "Done")
                MainActivity().doSomethingAndThrowException()
            } catch (exception: Exception) {
                Log.d("MultipleException2", exception.toString())
            }
            try {
                Log.d("ThirdJob", "Done")
                MainActivity().doSomethingAndThrowException()
            } catch (exception: Exception) {
                Log.d("MultipleException2", exception.toString())
            }


        }
    }

    fun multipleCoroutineExceptionHandlingWithoutScope() {
        GlobalScope.launch {

            try {

                    async {
                        MainActivity().doSomethingAndThrowException()
                    }
                    async {
                        MainActivity().doSomethingAndThrowException()
                    }
                    async {
                        MainActivity().doSomethingAndThrowException()
                    }

            } catch (exception: Exception) {
                Log.d("MultiCoroutineException", "Handled")
            }


        }
    }

    fun multipleCoroutineExceptionHandlingCoroutineScope()
    {
        GlobalScope.launch {

            try {
                coroutineScope {
                    async {
                        Log.d("FirstJob","Done")
                        MainActivity().doSomethingAndThrowException()
                    }
                    async {
                        Log.d("SecondJob","Done")
                        MainActivity().doSomethingAndThrowException()
                    }
                    async {
                        Log.d("Third","Done")
                        MainActivity().doSomethingAndThrowException()
                    }
                }
            } catch (exception: Exception) {
                Log.d("MultiCoroutineException", "Handled")
            }


        }
    }

    fun multipleCoroutineExceptionHandlingWithSuperVisor()  {
        GlobalScope.launch {

            try {
                supervisorScope {
                    async {
                        Log.d("FirstJob","Done")
                        MainActivity().doSomethingAndThrowException()
                    }
                    async {
                        Log.d("SecondJob","Done")
                        MainActivity().doSomethingAndThrowException()
                    }
                    async {
                        Log.d("Third","Done")
                        MainActivity().doSomethingAndThrowException()
                    }
                }
            } catch (exception: Exception) {
                Log.d("MultiCoroutineException", "Handled")
            }


        }
    }


}