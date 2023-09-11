package com.example.solidprinciples

class LiskovSubstitution {
}

// breaking liskov Principle
abstract class Vehicles {
    protected var isEngineWorking = false
    abstract fun startEngine()
    abstract fun stopEngine()
    abstract fun moveForward()
    abstract fun moveBack()
}

class Car : Vehicles() {
    override fun startEngine() {
        TODO("Not yet implemented")
    }

    override fun stopEngine() {
        TODO("Not yet implemented")
    }

    override fun moveForward() {
        TODO("Not yet implemented")
    }

    override fun moveBack() {
        TODO("Not yet implemented")
    }

}

class Cycle : Vehicles() {
    override fun startEngine() {
        TODO("Not yet implemented")
    }

    override fun stopEngine() {
        TODO("Not yet implemented")
    }

    override fun moveForward() {
        TODO("Not yet implemented")
    }

    override fun moveBack() {
        TODO("Not yet implemented")
    }
}
// it is breaking liskov principle because cycle don not support engine
////todo
//so the solution is


abstract class Vehicle {
    abstract fun moveForward()
    abstract fun moveBack()
}

abstract class EngineVehicles : Vehicle() {
    protected var isEngineWorking = false
    abstract fun startEngine()
    abstract fun stopEngine()
}

class Cars : EngineVehicles() {
    override fun startEngine() {
        TODO("Not yet implemented")
    }

    override fun stopEngine() {
        TODO("Not yet implemented")
    }

    override fun moveForward() {
        TODO("Not yet implemented")
    }

    override fun moveBack() {
        TODO("Not yet implemented")
    }

}

class Cycles : Vehicle() {
    override fun moveForward() {
        TODO("Not yet implemented")
    }

    override fun moveBack() {
        TODO("Not yet implemented")
    }

}

// here liskov substitution principle implemented



