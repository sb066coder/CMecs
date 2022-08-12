package ru.sb066coder

const val TIME_STEP = 1 // Единица времени - количество секунд
const val PRINT_STEP = 86400 // Шаг печати результата
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
        Velocity(Math.toRadians(90.0), 0.0, 1.0e+3)// 3.0291e+4
    )

    println(String.format("%03d day ${planet3.name} X: %12.5e Y: %12.5e Speed: %9.5f km/s - start", 0, planet3.position.x, planet3.position.y, planet3.velocity.getSpeed() / 1000))

    for(d in 0..400) {
        for(s in 0..PRINT_STEP){
            val force = Force(planet3, sun)
            planet3.move(arrayOf(force))
            if (s == PRINT_STEP) {
                println(
                    String.format(
                        "%03d day ${planet3.name} X: %12.5e Y: %12.5e Speed: %9.5f km/s MAX %9.5f MIN %9.5f",
                        d + 1,
                        planet3.position.x,
                        planet3.position.y,
                        planet3.velocity.getSpeed() / 1000,
                        planet3.velocity.maxSpeed / 1000,
                        planet3.velocity.minSpeed / 1000
                    ) + if (force.contact) " !!!CONTACT!!!" else ""
                )
            }
        }
    }
}