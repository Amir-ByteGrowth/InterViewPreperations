package com.example.solidprinciples

class InterfaceSegregationPrincipal {
}


interface Animals{
    fun eat()
    fun sleep()
    fun fly()
}

class Cats: Animals{
    override fun eat() {
        println("Cat is eating fish")
    }

    override fun sleep() {
        println("Cat is sleeping on its owner's bed")
    }

    override fun fly() {
        TODO("Not yet implemented") // Cats can't fly
    }
}

class Birds: Animals{
    override fun eat() {
        println("Bird is eating forage")
    }

    override fun sleep() {
        println("Bird is sleeping in the nest")
    }

    override fun fly() {
        println("Bird is flying so high")
    }
}



// here is solution
interface Animal{
    fun eat()
    fun sleep()
}

interface FlyingAnimal{
    fun fly()
}

class Cat: Animal{
    override fun eat() {
        println("Cat is eating fish")
    }

    override fun sleep() {
        println("Cat is sleeping on its owner's bed")
    }
}

class Bird: Animal, FlyingAnimal{
    override fun eat() {
        println("Bird is eating forage")
    }

    override fun sleep() {
        println("Bird is sleeping in the nest")
    }

    override fun fly() {
        println("Bird is flying so high")
    }
}