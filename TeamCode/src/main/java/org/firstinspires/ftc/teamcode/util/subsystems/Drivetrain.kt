package org.firstinspires.ftc.teamcode.util.subsystems

import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism

class Drivetrain : Mechanism {
    private val frontLeft = NextMotor("leftFront")
    private val frontRight = NextMotor("rightFront").apply { direction = NextMotor.Direction.REVERSE }
    private val backLeft = NextMotor("leftBack")
    private val backRight = NextMotor("rightBack").apply { direction = NextMotor.Direction.REVERSE }
}