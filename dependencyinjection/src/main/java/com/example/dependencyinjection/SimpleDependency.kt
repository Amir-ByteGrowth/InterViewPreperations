package com.example.dependencyinjection

import android.util.Log
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

// Constructor Injection

@ActivityScoped
class SimpleDependency @Inject constructor(engine: Engine, brand: Brand) {
    fun information() {
        Log.d("SimpleDependency", "Fun Information")
    }
}
// Constructor Injection
class Engine @Inject constructor() {

}

class Brand @Inject constructor() {

}