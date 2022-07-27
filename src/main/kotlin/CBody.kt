package ru.sb066coder

import kotlin.math.atan
import kotlin.math.pow
import kotlin.math.sqrt

// CMecs - Celestial Mechanics
// Class describes a space body
class CBody(_name: String, _mass: Double, _radius: Double, _position: Position, _velocity: Velocity = Velocity()) {
    val name: String = _name
    val mass: Double = _mass
    val radius: Double = _radius
    var position: Position = _position
    var velocity: Velocity = _velocity // x,y,z components of speed
    var lastAccs: LastAccs? = null

    /* Function shifts the body for a TIME_STEP interval
    функция принимает массив сил притяжения и время в секундах и задает новые значения:
    - координат объекта
    - скорости объекта по осям x,y,z
    */
    fun move(forces: Array<Force>, t: Int = TIME_STEP) {
        val accX = forces.fold(0.0) { acc, force -> acc + force.xComp } / mass
        val accY = forces.fold(0.0) { acc, force -> acc + force.yComp } / mass
        val accZ = forces.fold(0.0) { acc, force -> acc + force.zComp } / mass
        position.x += velocity.xComp * t + (accX + (accX * 2 - (lastAccs?.x ?: accX))) / 2 * t*t / 2
        position.y += velocity.yComp * t + (accY + (accY * 2 - (lastAccs?.y ?: accY))) / 2 * t*t / 2
        position.z += velocity.zComp * t + (accZ + (accZ * 2 - (lastAccs?.z ?: accZ))) / 2 * t*t / 2
        velocity.xComp += (accX + (accX * 2 - (lastAccs?.x ?: accX))) / 2 * t
        velocity.yComp += (accY + (accY * 2 - (lastAccs?.y ?: accY))) / 2 * t
        velocity.zComp += (accZ + (accZ * 2 - (lastAccs?.z ?: accZ))) / 2 * t
        lastAccs = LastAccs(accX, accY, accZ)
    }
}
