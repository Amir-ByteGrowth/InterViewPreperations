package com.example.solidprinciples

//invalid approach
//class Triangle {
//    var base = 0.0
//    var height = 0.0
//}
//
//class Square {
//    var side = 0.0
//}
//
//class AreaCalculate {
//    fun getTriangleArea(triangle: Triangle): Double {
//        return (triangle.base * triangle.height) / 2;
//    }
//
//    fun getSquareArea(square: Square): Double {
//        return square.side * square.side;
//    }
//}

//valid approach
open interface Shape {
    fun getArea(): Double
}

class Triangle : Shape {
    var base = 0.0
    var height = 0.0
    override fun getArea(): Double {
        return base * height / 2
    }
}

class Square : Shape {
    var side = 0.0
    override fun getArea(): Double {
        return side * side
    }
}

class AreaCalculate {
    fun getShapeArea(shape: Shape): Double {
        return shape.getArea()
    }
}


interface Greet {
    fun greet(): String
}

class Morning : Greet {
    override fun greet(): String {
        return "Good Morning Sir"
    }

}

class AfterNoon : Greet {
    override fun greet(): String {
        return "Good AfterNoon Sir"
    }

}

class Evening : Greet {
    override fun greet(): String {
        return "Good Evening Sir"
    }

}

class ShowGreetings(private var greet: Greet) {

    fun showGreetings() {
       println( greet.greet())
    }

}


