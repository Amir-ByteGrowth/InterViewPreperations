package com.example.functionsandclasses

import android.util.Log

object VariableNumberOfArguments {
    fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()
        for (t in ts) // ts is an Array
            result.add(t)
        return result
    }

    //     function as return type
    fun writeStuff(): (String) -> Int {
        return { 1 }
    }

    fun reduceList() {
        var intList = listOf(1, 2, 3)
        var sum = intList.reduce { acc, next -> acc + next }

    }

    fun oldList() {
        var intList = listOf(1.1, 2.3, 3.3)
        var sum = intList.fold("") { acc, next -> acc + next }

        Log.d("FoldExample", sum.toString())

    }

    fun foldToRightExp(){
        var numbers = listOf(5, 6, 7,8)
        val reversedIndexes = numbers.foldRightIndexed(10) { index,next, acc -> acc + next }

        Log.d("FoldExample", reversedIndexes.toString())
    }



    fun minByMaxBy(){
        val numbers = listOf(45, 42, 10, 4)
        val min3Remainder = numbers.maxWithOrNull (compareBy { it/3 })
        println(min3Remainder)

        val strings = listOf("one", "two", "three", "four")
        val longestString = strings.maxWithOrNull(compareBy { it.length })
        println(longestString)

        data class Person(val name: String, val age: Int)
        val people = listOf(
            Person("Alice", 25),
            Person("Bob", 30),
            Person("Charlie", 20)
        )


    }


}