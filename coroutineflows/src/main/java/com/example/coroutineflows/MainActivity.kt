package com.example.coroutineflows

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutineflows.stateflowvssharedflow.MyViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainActivity : AppCompatActivity() {

    fun simple(): Flow<Int> = flow {
        println("Flow started")
        for (i in 1..3) {
            delay(1000L)
            emit(i)
        }
    }

    var TAG = "MainActivity"

    lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel = MyViewModel()

//        GlobalScope.launch {
//            myViewModel.myStateFlow.collect {
//                Log.d("StateFlowVal", it.toString())
//            }
//
//
//        }
//
//        GlobalScope.launch {
//            myViewModel.myStateFlow.collect {
//                Log.d("StateFlowVal1", it.toString())
//            }
//
//
//
//        }
//        GlobalScope.launch {
//            myViewModel.myStateFlow.collect {
//                delay(2000L)
//                Log.d("StateFlowVal2", it.toString())
//
//            }
////
////
//        }
//        GlobalScope.launch {
////            delay(100L)
//            myViewModel.setMyStateFlowValues()
//            delay(5000L)
//                    myViewModel._myStateFlow.value=6
//        }


//        GlobalScope.launch {
//            myViewModel.mySharedFlow.collect{
//                Log.d("MySharedFlow1", it.toString())
//            }
//        }
//
//        GlobalScope.launch {
//            myViewModel.mySharedFlow.collect{
//                Log.d("MySharedFlow2", it.toString())
//            }
//        }
//
//
//        myViewModel.setMySharedValue()
//
//        GlobalScope.launch {
//
//            delay(3000L)
////            myViewModel.mySharedFlow.emit(100)
//            Log.d("HereDelayFun","Executed")
//            myViewModel.mySharedFlow.collect{
//                Log.d("MySharedFlowDelayed", it.toString())
//            }
//        }


//        GlobalScope.launch {
//            simple().map { (it * it).toString() }.filter { it == "4" }.collect { value ->
//                Log.d("FlowValue", value.toString())
//            }
//
//            (1..5).asFlow()
//                .map {
//
//                    // raise exception when the value is 3, intentionally done for the sake of example
//                    check(it != 3) { "Value $it" } // raise exception
//                    it * it
//                }.transform { emit("Amir")  }
//                .onCompletion {
//                    Log.d(TAG, "onCompletion")
//                }
//                .catch { e ->
//                    Log.d(TAG, "Caught $e")
//                }
//                .collect {
//                    Log.d(TAG, it.toString())
//                }
//        }

//        FlowOperators.reduceOperator()
//        FlowOperators.flowOnOperator()
//        ListPartitionClass.partitionList()
//        HotVsColdFlow.getValuesFromSharedFlow()
//        RetryAndRetryWhen.retryFun()


        var parallelNetworkCalls = ParallelNetworkCalls()

        parallelNetworkCalls.combineTwoNetworkCalls()
    }
}