package ru.sb066coder

class CDummy(_position: Position) {
    val position = _position

    fun update(velocity: Velocity) {
        position.x = position.x + velocity.xComp * TIME_STEP
        position.y = position.y + velocity.yComp * TIME_STEP
        position.z = position.z + velocity.zComp * TIME_STEP
    }
}
