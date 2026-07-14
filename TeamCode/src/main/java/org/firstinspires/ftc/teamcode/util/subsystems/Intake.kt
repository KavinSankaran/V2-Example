package org.firstinspires.ftc.teamcode.util.subsystems

import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.triggers.CommandGamepad

class Intake : Mechanism {
    private val intake = NextMotor("Intake").apply { direction = NextMotor.Direction.REVERSE }

    val on = instant { intake.setThrottle(1.0) }
    val off = instant { intake.setThrottle(0.0) }
    val reverse = instant { intake.setThrottle(-1.0) }
    fun custom(gamepad: CommandGamepad) = infinite { intake.setThrottle(gamepad.rightStickY.toDouble()) }
}