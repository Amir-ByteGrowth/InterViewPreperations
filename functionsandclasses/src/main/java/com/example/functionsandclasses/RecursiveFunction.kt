package com.example.functionsandclasses

import android.util.Log

object RecursiveFunction {

     fun show1000numbers(x: Int) {
        if (x != 1) {
            Log.d("Recursive", x.toString())
            show1000numbers(x - 1)
        }

    }
}