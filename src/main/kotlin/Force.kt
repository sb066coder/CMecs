package ru.sb066coder

import kotlin.math.pow
import kotlin.math.sqrt


const val GR_CONST = 6.6743e-11
class Force (first: CBody, second: CBody) {
    private val dx = second.position.x - first.position.x
    private val dy = second.position.y - first.position.y
    private val dz = second.position.z - first.position.z
    private val distance = sqrt(dx * dx + dy * dy + dz * dz)
    private val acceptedDistance = maxOf(distance, first.radius + second.radius)
    private val amount: Double = GR_CONST * first.mass * second.mass / acceptedDistance.pow(2)
    val contact = acceptedDistance != distance
    val xComp: Double = amount * dx / acceptedDistance
    val yComp: Double = amount * dy / acceptedDistance
    val zComp: Double = amount * dz / acceptedDistance
//    private val dxDum = second.dummy.position.x - first.dummy.position.x
//    private val dyDum = second.dummy.position.y - first.dummy.position.y
//    private val dzDum = second.dummy.position.z - first.dummy.position.z
//    private val distanceDum = sqrt(dxDum * dxDum + dyDum * dyDum + dzDum * dzDum)
//    private val amountDum: Double = GR_CONST * first.mass * second.mass / distanceDum.pow(2)
//    val xDum: Double = amountDum * dxDum / distanceDum
//    val yDum: Double = amountDum * dyDum / distanceDum
//    val zDum: Double = amountDum * dzDum / distanceDum
}
