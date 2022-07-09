package ru.sb066coder

import kotlin.math.PI

const val TIME_STEP = 86400
fun main() {
    val sun = CBody(
        "Sun",
        1.9891e+30,
        1.392e+9,
        Position(0.0, 0.0),
        Velocity(Vector(0.0), 0.0)
    )
    val planet3 = CBody(
        "Earth",
        5.9726e24,
        1.2742e7,
        Position(1.4709829e11,0.0),
        Velocity(Vector(90.0 * PI / 180),0.0)// 2.9783e+4
    )
    repeat(10) {
        planet3.move(arrayOf(Force(planet3, sun)))
        println("${planet3.name} X: ${planet3.position.x} Y: ${planet3.position.y} Speed: ${planet3.velocity.speed / 1000} km/s")
        Thread.sleep(500)
    }
}