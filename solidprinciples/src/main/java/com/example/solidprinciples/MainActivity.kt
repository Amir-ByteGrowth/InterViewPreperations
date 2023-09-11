package com.example.solidprinciples

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val handler = CoroutineExceptionHandler { _, exception ->

        Log.d("ExceptionHere", exception.toString())

    }

     fun doSomethingAndThrowException() {
        throw Exception("Some Exception")
    }

    fun throughExceptionOnCoroutine() {

            GlobalScope.launch(Dispatchers.Main+handler ) {
                throw Exception("Some Exception")
            }

        GlobalScope.launch {
            try {
                doSomethingAndThrowException()
            } catch (exception: Exception) {
                // handle exception
                Log.d("SecondExceptionHere", exception.toString())
            }
        }


    }

    fun asynchExceptionHandler(){
        GlobalScope.launch{
            doSomethingAndThrowException()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var jobTracker = JobTracker()
        jobTracker.setCurrentConditions("")

        var showGreetings = ShowGreetings(AfterNoon())
        showGreetings.showGreetings()

//        throughExceptionOnCoroutine()
//        asynchExceptionHandler()

//        var value = GlobalScope.async {
//            delay(5000L)
//            return@async 10
//        }
//
//
//        var job1 = GlobalScope.launch {
//            delay(5000L)
//            Log.d("Job1", "5Sec")
//        }
//        var job2 = GlobalScope.launch {
//            delay(10000L)
//            Log.d("Job2", "10Sec")
//        }
//
//        GlobalScope.launch {
//            withContext(Dispatchers.Main) {
//                job1.join()
//                job2.join()
//                Log.d("Job3", "Jobs completed")
//            }
//        }
//
//
//        lifecycleScope.launch {
//
//        }
//
//        GlobalScope.launch {
//            var number = value.await()
//            Log.d("Returning number is", number.toString())
//        }


        ParallelCoroutines.multipleCoroutineExceptionHandlingWithSuperVisor()

    }





}