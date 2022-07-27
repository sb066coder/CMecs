package ru.sb066coder

const val TIME_STEP = 225 // Единица времени - количество секунд
const val PRINT_STEP = 384 // Шаг печати результата
fun main() {
    val sun = CBody(
        "Sun",
        1.9891e+30,
        1.392e+9,
        Position(0.0, 0.0),
        Velocity()
    )
    val planet3 = CBody(
        "Earth",
        5.9726e24,
        1.2742e7,
        Position(1.47098074e11,0.0),
        Velocity(Math.toRadians(90.0), 0.0, 3.0291E+04)// 2.9783e+4
    )

    println(String.format("%03d day ${planet3.name} X: %12.5e Y: %12.5e Speed: %9.5f km/s - start", 0, planet3.position.x, planet3.position.y, planet3.velocity.getSpeed() / 1000))

    repeat(370) {
        repeat(PRINT_STEP){
            planet3.move(arrayOf(Force(planet3, sun)))
        }
        println(String.format("%03d day ${planet3.name} X: %12.5e Y: %12.5e Speed: %9.5f km/s", it+1, planet3.position.x, planet3.position.y, planet3.velocity.getSpeed() / 1000))
    }
}