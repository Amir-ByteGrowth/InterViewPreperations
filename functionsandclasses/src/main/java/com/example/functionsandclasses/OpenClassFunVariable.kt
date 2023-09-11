package com.example.functionsandclasses

import android.util.Log

class OpenClassFunVariable {
}

//class Mentor{
//
//}

open class Mentor {

}

// by default classes, functions, variables  in kotlin are final we have to  use open iff we want to inherit it
class Guide : Mentor() {

}


open class A {
    var TAG = "OpenClass"
    open var a = 0
    open fun showMessage() {
        Log.d(TAG, "ClassA  $a")
    }
}

class B : A() {
    override var a: Int = 5


    override fun showMessage() {
        Log.d(TAG, "ClassB  $a")
        super.showMessage()
    }
}

open class FunctionWithDefaultVal {
    open var TAG = "FunctionWithDefaultVal"
    open fun funWithDefaultVal(a: Int = 5) {}
}

class ChildFunWithDefaultValue : FunctionWithDefaultVal() {
    override fun funWithDefaultVal(a: Int) {
        Log.d(TAG, "$a ValueFound")
    }
}


object Checking {
    fun showAValue() {
        var a = A()
        a.showMessage()
        var b = B()
        b.showMessage()
    }

    fun showOverrideMethodDefaultValue() {
        var childFunWithDefaultValue = ChildFunWithDefaultValue()
        childFunWithDefaultValue.funWithDefaultVal()
    }
}