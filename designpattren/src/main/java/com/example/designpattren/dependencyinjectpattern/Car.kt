package com.example.designpattren.dependencyinjectpattern

//class without dependency injection

class Car {
    var engine: Engine = Engine()
    var name: String = "Honda"

    init {
        engine.engineName
    }
}

class Engine {
    var engineName = ""
}