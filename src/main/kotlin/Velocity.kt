package ru.sb066coder

import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

class Velocity (alpha: Double = 0.0, beta: Double = 0.0, _speed: Double = 0.0) {
    var xComp: Double = _speed * cos(beta) * cos(alpha)
    var yComp: Double = _speed * cos(beta) * sin(alpha)
    var zComp: Double = _speed * sin(beta)

    fun getSpeed(): Double = sqrt(xComp * xComp + yComp * yComp + zComp * zComp)
}