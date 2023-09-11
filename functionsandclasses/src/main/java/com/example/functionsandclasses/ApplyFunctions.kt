package com.example.functionsandclasses

import android.util.Log

object ApplyFunctions {

    data class Person(var name: String, var age: Int = 1)

    var TAG = "ApplyScoped"
    fun setPersonWithApply() {
        var person = Person(name = "Amir").apply { age = 8 }
        person.apply {
            name = "Rashid"
            age = 27
        }.let { person -> Log.d(TAG, person.toString()) }
    }

}