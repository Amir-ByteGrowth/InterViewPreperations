package com.example.designpattren

import android.util.Log

class FacadePattern {
}

interface Shape {
    fun drawShape()
}

class Circle : Shape {

    override fun drawShape() {
        Log.d("Shape", "Circle")
    }

}

class Rectangle : Shape {

    override fun drawShape() {
        Log.d("Shape", "Rectangle")
    }

}

class Triangle : Shape {

    override fun drawShape() {
        Log.d("Shape", "Triangle")
    }

}

class DrawDesiredShape {
    lateinit var circle: Shape
    lateinit var triangle: Shape
    lateinit var rectangle: Shape

    init {
        circle = Circle()
        triangle = Triangle()
        rectangle = Rectangle()
    }

    fun drawCircle() {
        circle.drawShape()
    }

    fun drawTriangle() {
        triangle.drawShape()
    }

    fun drawRectangle() {
        rectangle.drawShape()
    }

}