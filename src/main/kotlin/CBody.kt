package ru.sb066coder

// CMecs - Celestial Mechanics
// Class describes a space body
class CBody(_name: String, _mass: Double, _radius: Double = 0.0, _position: Position, _velocity: Velocity = Velocity()) {
    val name: String = _name
    val mass: Double = _mass
    val radius: Double = _radius
    var position: Position = _position
    var velocity: Velocity = _velocity // x,y,z components of speed
    val dummy = CDummy(
        Position(
            position.x + velocity.xComp * TIME_STEP,
            position.y + velocity.yComp * TIME_STEP,
            position.z + velocity.zComp * TIME_STEP,
        )
    )

    /* Function shifts the body for a TIME_STEP interval
    функция принимает массив сил притяжения и время в секундах и задает новые значения:
    - координат объекта
    - скорости объекта по осям x,y,z
    */
    fun move(forces: Array<Force>, t: Int = TIME_STEP) {
        val accX = forces.fold(0.0) { acc, force -> acc + (force.xComp + force.xDum) / 2 } / mass
        val accY = forces.fold(0.0) { acc, force -> acc + (force.yComp + force.yDum) / 2 } / mass
        val accZ = forces.fold(0.0) { acc, force -> acc + (force.zComp + force.zDum) / 2 } / mass
        position.x += velocity.xComp * t + accX * t*t / 2
        position.y += velocity.yComp * t + accY * t*t / 2
        position.z += velocity.zComp * t + accZ * t*t / 2
        velocity.xComp += accX * t
        velocity.yComp += accY * t
        velocity.zComp += accZ * t
        dummy.update(velocity)
    }

}
