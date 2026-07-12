package org.firstinspires.ftc.teamcode.util.subsystems

import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.hardware.sensors.NextDigitalSensor
import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.Telemetry

class Intake : Mechanism {
    private val intake = NextMotor("Intake")
    private val beam = NextDigitalSensor("breakBeam")

    private var count = 0
    private var lastDetected = false
    val artifactCount: Int
        get() = count

    val on = instant { intake.setThrottle(1.0) }
    val off = instant { intake.setThrottle(0.0) }
    val reverse = instant { intake.setThrottle(-1.0) }
    fun custom(power: () -> Float) = infinite { intake.setThrottle(power().toDouble()) }
    fun resetCount(){ count = 0 }

    override fun periodic() {
        val detected: Boolean = beam.isTriggered
        if (detected && !lastDetected) count ++
        lastDetected = detected

        Telemetry.log("State", beam.debug())
        Telemetry.log("Count", count)
    }
}