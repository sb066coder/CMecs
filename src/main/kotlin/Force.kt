package ru.sb066coder

import kotlin.math.*

const val GR_CONST = 6.6743e-11
class Force (val first: CBody, val second: CBody) {
    val dx = second.position.x - first.position.x
    val dy = second.position.y - first.position.y
    val dz = second.position.z - first.position.z
    val distance = sqrt(dx * dx + dy * dy + dz * dz)
    val amount: Double = GR_CONST * first.mass * second.mass / distance.pow(2)
    val xComp: Double = amount * dx / distance
    val yComp: Double = amount * dy / distance
    val zComp: Double = amount * dz / distance
}
