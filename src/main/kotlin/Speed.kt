package ru.sb066coder

class Speed (_vector: Vector = Vector(), _amount: Double = 0.0) {
    var vector: Vector = _vector
    var amount: Double = _amount

    fun getXShift(): Double = vector.x * amount
    fun getYShift(): Double = vector.y * amount
}