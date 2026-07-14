package org.firstinspires.ftc.teamcode.util.subsystems

import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.hardware.sensors.NextDigitalSensor
import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.Telemetry
import dev.nextftc.robot.triggers.CommandGamepad

class Intake : Mechanism {
    private val intake = NextMotor("Intake").apply { direction = NextMotor.Direction.REVERSE }
    private val beam = NextDigitalSensor("breakBeam")

    private var count = 0
    private var lastDetected = false

    val artifacts
        get() = count

    val on = instant { intake.setThrottle(1.0) }
    val off = instant { intake.setThrottle(0.0) }
    val reverse = instant { intake.setThrottle(-1.0) }
    fun custom(gamepad: CommandGamepad) = infinite { intake.setThrottle(gamepad.rightStickY.toDouble()) }

    fun reset(){
        count = 0
        lastDetected = beam.isTriggered
    }

    override fun periodic() {
        val detected: Boolean = beam.isTriggered
        if (detected && !lastDetected) count++
        lastDetected = detected


        Telemetry.log(if (detected) "object detected" else "no object detected")
        Telemetry.log("count", count)
    }
}