package com.example.functionsandclasses

import android.util.Log

class InlineNoInlineCrossLine {
    fun mainFunction() {
        println("First Line")
        showInstruct { println("Show Instruct") }
        println("Second Line")

//        noInlineLineFun({ Log.d("AbcCalled", "Called") }, { a, b -> a + b }, { a, b -> a - b })


        crossLineFun({

            Log.d("AbcCalled", "Called")
                     }, { a, b ->
            a + b
        }, { a, b ->
            a - b
        })


    }

    inline fun showInstruct(abc: () -> Unit) {
        abc()
        println("Show Instruct")

    }


    inline fun noInlineLineFun(
        abc: () -> Unit,
        sum: (a: Int, b: Int) -> Int,
        noinline sub: (a: Int, b: Int) -> Int
    ) {
        abc()
        Log.d("Sum", sum(4, 5).toString())
        Log.d("Sub", sub(6, 5).toString())
        println("Show Instruct")
    }

    inline fun crossLineFun(
       crossinline abc: () -> Unit,
        sum: (a: Int, b: Int) -> Int,
        noinline sub: (a: Int, b: Int) -> Int
    ) {
        abc()
        Log.d("Sum", sum(4, 5).toString())
        Log.d("Sub", sub(6, 5).toString())
        println("Show Instruct")
    }


}