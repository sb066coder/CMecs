package ru.sb066coder

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class Vector (_angle: Double) {
    var angle: Double = _angle % (PI * 2)
    var x: Double = 0.0
        set(angle) {field = cos(angle)}
    var y: Double = 1.0
        set(angle) {field = sin(angle)}
    init {
        x = angle
        y = angle
    }

//    private fun setX(angle: Double) { x = cos(angle) }
//    private fun setY(angle: Double) { x = sin(angle) }
    //var z: Double = 0.0 Допустим пока объекты вращаются в плоскости

//    fun setY(x: Double) {
//        y = sqrt(1 - x * x)
//    }
}