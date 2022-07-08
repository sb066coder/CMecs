package ru.sb066coder

//Celestial Mechanics

class CBody(_name: String, _mass: Double, _radius: Double, _position: Position, _speed: Speed = Speed()) {
    val name: String = _name
    val mass: Double = _mass
    val radius: Double = _radius
    var position: Position = _position
    var speed: Speed = _speed

    fun move(forces: Array<Force>) {
        position.x += speed.getXShift()
        position.y += speed.getYShift()
    }
}