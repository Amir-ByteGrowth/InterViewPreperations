package com.example.interviewpreperations.nestedvsinnerclass

class NestedClassExp {
    var a = 2

    class NestedClass {
        //        fun getVal()=a  nested class is static class by default and it is not bound to object is wrapping class it can not access the member of its wrapping class
        fun getVal() = 2
    }

    fun main() {
        var nestedClassExp = NestedClassExp()
//        nestedClassExp.NestedClass() it is not accessable
        var nestedClass = NestedClass()
        nestedClass.getVal()

    }
}