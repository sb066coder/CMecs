package ru.sb066coder

//Celestial Mechanics

class CBody(_name: String, _mass: Double, _radius: Double) {
    val name: String = _name
    val mass: Double = _mass
    val radius: Double = _radius
    var speed: Speed = Speed()

    fun move(forces: Array<Force>) {

    }
}