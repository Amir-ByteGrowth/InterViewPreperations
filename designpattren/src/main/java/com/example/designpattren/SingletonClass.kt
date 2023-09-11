package com.example.designpattren

import android.content.Context
import android.util.Log
import android.widget.Toast

object SingletonClass {
    init {
        Log.d("SingleTon", "Object Created")
    }

    fun showToast(context: Context) {
        Log.d("SingleTon", "Method called")
        Toast.makeText(context, "Singleton object created", Toast.LENGTH_SHORT).show()
    }
}