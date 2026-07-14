package org.firstinspires.ftc.teamcode.util.subsystems

import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import kotlin.math.abs
import kotlin.math.max

class Drivetrain : Mechanism {
    val lf = NextMotor("lf")
    val lb = NextMotor("lb").apply { direction = NextMotor.Direction.REVERSE }
    val rf = NextMotor("rf")
    val rb = NextMotor("rb").apply { direction = NextMotor.Direction.REVERSE }

    fun drive(x: Float, y: Float, rx: Float) = infinite {
        val denominator = max((abs(x) + abs(y) + abs(rx)).toDouble(), 1.0)

        lf.setThrottle((y + x + rx).toDouble()/denominator)
        lb.setThrottle((y + x + rx).toDouble()/denominator)
        rf.setThrottle((y - x + rx).toDouble()/denominator)
        rb.setThrottle((y - x + rx).toDouble()/denominator)
    }
}