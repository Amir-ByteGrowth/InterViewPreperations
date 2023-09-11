package com.example.coroutineflows

object InfixFunction {
    infix fun Int.add(value: Int): Int = this + value
}