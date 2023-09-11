package com.example.functionsandclasses

import android.util.Log

object ScopedFunctions {
    var TAG = "ScopedFunctions"

    data class A(var a: Int = 1)

    fun letScopedFunction() {
        var str = "Here is Amir"
        var a = A()
        var length = str.let {
            Log.d(TAG, it)
            it.length
        }.let {
            it + 10
        }
        Log.d(TAG, length.toString())

        a.let {
            it.a = 6

        }
        a.run {
            this
        }
        Log.d(TAG, a.a.toString())
    }


    fun runScopedFunction() {
        var tutorial = "This is Kotlin Tutorial"
        println(TAG + tutorial) //This is Kotlin Tutorial
        tutorial = run {
            val tutorial = "This is run function"
            tutorial
        }
        println(TAG + tutorial) //This is run function
    }

    fun runWithLet() {
        var p: String? = "P is executed"
        p = p?.let {
            println("p is $p")
            "Let executed"
        } ?: run { "Run Executed" }

        Log.d(TAG, p)
//Prints
//p was null. Setting default value to:
//Kotlin
    }


    fun checkFunction() {
        val numbers = mutableListOf("one", "two", "three", "four", "five")
//        val resultList = numbers.map { it.length }.filter { it > 3 }
//        println(resultList[0])

        var a: Int? = 0
        a.apply {

        }
        var num = numbers.map { it.length }.filter { it > 3 }.let { A() }
        Log.d(TAG, num.a.toString())
    }

    inline fun showMessage(str: Any) {
        Log.d(TAG, str.toString())
    }

    fun main() {
        val numbers = mutableListOf("One","Two","Three","Four","Five")
        val resultsList = numbers.map { it.length }.filter { it > 3 }.let { println(it) }
        print(resultsList)
    }
}