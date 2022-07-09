package ru.sb066coder

import kotlin.math.*

const val GR_CONST = 6.6743e-11
class Force (val first: CBody, val second: CBody) {
    val dx = second.position.x - first.position.x
    val dy = second.position.y - first.position.y
    val distance = sqrt(dx * dx + dy * dy)
    var vector: Vector = Vector(if (asin(dy/distance) >= 0) acos(dx/distance) else 2 * PI - acos(dx/distance))
    var amount: Double = GR_CONST * first.mass * second.mass / distance.pow(2)
    init {
        println("Force [${first.name} ${second.name}] dist: $distance, amount: $amount, ang: ${vector.angle}")
    }
}
