package ru.sb066coder

fun main() {
    val planet = CBody(
        "Earth",
        5.9726e24,
        1.2742e7,
        Position(1.4709829e11,0.0),
        Speed(Vector(0.0, 1.0),2.9783e4)
    )
    repeat(10) {
        planet.move(emptyArray())
        println("${planet.name} X: ${planet.position.x} Y: ${planet.position.y}")
        Thread.sleep(500)
    }
}