package com.example.interviewpreperations.nestedvsinnerclass

class InnerClassExp {
    var a = 2

    inner class InnerClass {
        fun getVal() = a
    }
}

//Kotlin uses explicit keywords to clear up the confusion between nested classes and inner classes. To recap:
//
//A nested class is a static class defined inside another class. It is not bound to a specific instance of the outer class.
//An inner class is a non-static class defined inside another class. it is bound to a specific instance of the outer class.
//Inner classes are declared using the inner keyword. A nested class marked as inner can access the members of its outer class.

fun main() {
    var innerClassExp = InnerClassExp()
    innerClassExp.InnerClass().getVal()
}