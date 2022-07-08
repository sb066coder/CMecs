package ru.sb066coder

import kotlin.math.sqrt

class Vector {
    var x: Double = 1.0
    private var y: Double = 0.0
    //var z: Double = 0.0 Допустим пока объекты вращаются в плоскости

    fun setY(x: Double) {
        y = sqrt(1 - x * x)
    }


}