package com.example.functionsandclasses

import android.util.Log

class GenericClasses<T>(age: T) {
    var age: T = age

    init {
        Log.d("GenericClass", age.toString())
    }


    fun <T> ItemsList(itemList: List<T>): List<T> {

        return itemList
    }
}