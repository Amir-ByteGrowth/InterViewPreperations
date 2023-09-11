package com.example.functionsandclasses

object LambdaExpression {

    val sum: (Int) -> Int = {
        val a = it
        a
    }

    val sumAB: (a: Int, b: Int) -> Int = { a, b -> a + b }

}