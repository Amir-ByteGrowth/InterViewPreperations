package com.example.dependencyinjection

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppModuleTestClass @Inject constructor(var apiKey: String,var libKey: String) {
    fun showApiKeys(){
        Log.d("KeysHere", "$apiKey  $libKey")
    }
}