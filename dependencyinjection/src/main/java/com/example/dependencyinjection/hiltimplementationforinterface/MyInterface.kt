package com.example.dependencyinjection.hiltimplementationforinterface

import com.example.dependencyinjection.ApplicationModule
import javax.inject.Inject
import javax.inject.Singleton

interface MyInterface {
    fun myPrintFunction(): String
}


class MyInterfaceImplementer @Inject constructor() : MyInterface {
    override fun myPrintFunction(): String {
        return "My interface implementer called"
    }
}


class MyInterfaceImplementerSecond @Inject constructor() : MyInterface {
    override fun myPrintFunction(): String {
        return "My Second interface implementer called"
    }
}


class UserInterface @Inject constructor(@ApplicationModule.MyInterfaceOne var myInterfaceImplementer: MyInterface) {
    fun myFun(): String {
        return "Working:${myInterfaceImplementer.myPrintFunction()}"
    }

}
@Singleton
class UserInterfaceSecond @Inject constructor(
      var myInterfaceImplementer: MyInterface,
   var myInterfaceImplementerSecond: MyInterface
) {
    fun myFun(): String {
        return "Working:${myInterfaceImplementer.myPrintFunction()}"
    }

    fun myFunSecond(): String {
        return "WorkingSecond:${myInterfaceImplementerSecond.myPrintFunction()}"
    }

}

