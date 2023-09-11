package com.example.functionsandclasses

import android.util.Log

object EqualOperator {

    fun checkClassEquality() {
        var color = Color("red")
        var color2 = Color("red")
        var color3 = color

        var colorData = ColorData("red")
        var colorData1 = ColorData("red")

        Log.d("ColorsEquality", (color === color2).toString())
        Log.d("ColorsEquality", (color.name.equals(color2.name)).toString())
        Log.d("ColorsEquality", (color === color3).toString())

        Log.d("ColorsDataEquality", (colorData == colorData1).toString())
    }


    class Color(name: String) {
        var name: String

        init {
            this.name = name
        }
    }

    data class ColorData(var name: String) {}
    class Primary(a: Int, b: Int) {
        lateinit var count:String
        val sun:Int by lazy (LazyThreadSafetyMode.SYNCHRONIZED){ 10 }
        init {
            count="Amir"
        }

        constructor(a: Int, b: Int,c:Int) :this(a,b) {

        }

    }

}