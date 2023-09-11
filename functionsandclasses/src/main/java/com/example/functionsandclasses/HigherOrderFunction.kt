package com.example.functionsandclasses

object HigherOrderFunction {

    fun sum(a: Int, b: Int) = a + b

    fun takeFunctionAsParam(sumAB: (a: Int, b: Int) -> Int): Int {
        return sumAB(5, 6)
    }


    fun returnFunction(): (a: Int, b: Int) -> Int {
        return ::sum
    }


}