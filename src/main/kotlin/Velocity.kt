package ru.sb066coder

class Velocity (_vector: Vector = Vector(0.0), _speed: Double = 0.0) {
    var vector: Vector = _vector
    var speed: Double = _speed

    fun getXShift(forces: Array<Force>, mass: Double): Double =
        (vector.x * speed + forces.fold(0.0) { acc, force -> acc + force.vector.x * force.amount / mass }) * TIME_STEP

    fun getYShift(forces: Array<Force>, mass: Double): Double =
        (vector.y * speed + forces.fold(0.0) { acc, force -> acc + force.vector.y * force.amount / mass  }) * TIME_STEP
}