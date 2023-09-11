package com.example.functionsandclasses

object VisibilityModifierParent {


    private fun foo() {} // visible inside example.kt

    public var bar: Int = 5 // property is visible everywhere
        private set         // setter is visible only in example.kt

    internal val baz = 6

}

class PrivateConstructor private constructor(a: Int) {
    lateinit var ab: String


    init {
        ab = a.toString()
    }


    constructor(a: Int, b: String) : this(a)

}


open class InheritParent {
    private var aPrivate: Int = 5
    open var bPublic = 5
    protected open var cProtected = 5
    internal var dInternal = 5
    open var g = 5

    open fun publicFun() {}
}


class ChildInherit : InheritParent() {
    override var bPublic: Int
        get() = super.bPublic
        set(value) {
            super.bPublic = value
        }
    override var g = 7
    override var cProtected: Int
        get() = super.cProtected
        set(value) {
            super.cProtected
        }

    override fun publicFun() {

    }
}