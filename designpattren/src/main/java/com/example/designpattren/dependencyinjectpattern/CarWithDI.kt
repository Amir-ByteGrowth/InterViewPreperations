package com.example.designpattren.dependencyinjectpattern

import android.util.Log

class CarWithDI {
    lateinit var engineDI: EngineDI

    fun showEngine() {
        engineDI.showEngine()
    }

}

open class EngineDI {
    open fun showEngine() {
        Log.d("CarWithDI", "SimpleEngine")
    }
}

class EngineChild : EngineDI() {
    override fun showEngine() {
        Log.d("CarWithDI", "EngineChild")
        super.showEngine()
    }
}

class CarConstructorDi(private var engineDI: EngineDI) {
    fun showEngine() {
        engineDI.showEngine()
    }
}


fun mainMethod() {
    var engineDI = EngineChild()
    var carWithDI = CarWithDI()
    carWithDI.engineDI = engineDI
    engineDI.showEngine()


    var carConstructorDi = CarConstructorDi(engineDI)
    carConstructorDi.showEngine()

}