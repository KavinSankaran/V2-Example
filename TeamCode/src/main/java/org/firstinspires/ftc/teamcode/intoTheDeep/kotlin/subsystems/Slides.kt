package org.firstinspires.ftc.teamcode.intoTheDeep.kotlin.subsystems

import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import dev.nextftc.units.radians
import kotlin.math.PI

class Slides : Mechanism {
    private val anglePerTick = (2 * PI / 537.7).radians
    val left = NextMotor("left", anglePerTick).apply {
        positionConstants.kP = 0.1
        positionConstants.kD = 0.001
        positionConstants.kS = 0.02
        positionConstants.kG = 0.4
    }

    val right = NextMotor("right", anglePerTick).apply {
        follow(left, NextMotor.Direction.REVERSE)
    }

    val up = instant { left.setPositionSetpoint(ticksToAngle(4000.0)) }
    val down = instant { left.setPositionSetpoint(ticksToAngle(0.0)) }
    val middle = instant { left.setPositionSetpoint(ticksToAngle(2000.0)) }

    fun ticksToAngle(ticks: Double) = anglePerTick.times(ticks)
}