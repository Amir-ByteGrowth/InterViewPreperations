package com.example.coroutineflows

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

object FlowOperators {
    var simpleFlow = flowOf(1, 2, 3, 4, 5, 6, 7, 8, 9).onEach { delay(500L) }
    var namesList = flowOf("Amir", "Rashid", "Nomi", "Rehman").onEach { delay(500L) }

    //terminal operators
    //firs, last, tolist, toset, reduce, fold
    fun flowFirstOperator() {
        GlobalScope.launch {
            Log.d("First Item", simpleFlow.first { it == 3 }.toString())
        }
    }

    fun reduceOperator() {
        GlobalScope.launch {
            Log.d("ReducedItem", simpleFlow.reduce { a, b -> a + b }.toString())
        }
    }

    fun foldOperator() {
        GlobalScope.launch {

            Log.d("FoldItem", simpleFlow.fold(4) { acc, i -> acc + i }.toString())
        }
    }

    //    intermediate operator
//    filter, map,transform, take
    fun filterOperator() {
        GlobalScope.launch {
            namesList.filter { it.length > 4 }.collect {
                Log.d("MapFilter", it.toString())
            }
        }
    }

    fun mapOperator() {
        GlobalScope.launch {
            namesList.map { it + "Done" }.collect {
                Log.d("MapFilter", it.toString())
            }
        }
    }

    fun takeOperator() {
        GlobalScope.launch {
            namesList.take(6).map { it + "Done" }.collect {
                Log.d("MapFilter", it.toString())
            }
        }
    }

    fun transformOperator() {
        GlobalScope.launch {
            namesList.transform {
                emit(it)
                emit("New")
                emit("Old")
                emit(1)
            }.collect {
                Log.d("Transformed", it.toString())
            }
        }
    }

    // combining operator
    fun combineOperator() {
        GlobalScope.launch {
            namesList.combine(simpleFlow) { f1, f2 -> f1 + f2 }.collect {
                Log.d("Combined", it)
            }
        }
    }

    fun zipOperator() {
        GlobalScope.launch {
            namesList.zip(simpleFlow) { f1, f2 -> f1 + f2 }.collect {
                Log.d("Combined", it)
            }
        }
    }


    fun flatMergeOperator() {

        var newFlow = namesList.flatMapMerge { flowOf(it + "Amir") }
        GlobalScope.launch {
            newFlow.collect {
                Log.d("FlatMerge", it)
            }
        }
    }


    // change context operator

    fun flowOnOperator() {

        var newFlow = namesList.flatMapMerge { flowOf(it + "Amir") }.flowOn(Dispatchers.Main)
        GlobalScope.launch {
            newFlow.collect {
                Log.d("FlowOn", it)
            }
            
        }
    }


}