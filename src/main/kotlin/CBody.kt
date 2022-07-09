package ru.sb066coder

//Celestial Mechanics

class CBody(_name: String, _mass: Double, _radius: Double, _position: Position, _velocity: Velocity = Velocity()) {
    val name: String = _name
    val mass: Double = _mass
    val radius: Double = _radius
    var position: Position = _position
    var velocity: Velocity = _velocity

    fun move(forces: Array<Force>) {
        position.x += velocity.getXShift(forces, mass)
        position.y += velocity.getYShift(forces, mass)
    }
}