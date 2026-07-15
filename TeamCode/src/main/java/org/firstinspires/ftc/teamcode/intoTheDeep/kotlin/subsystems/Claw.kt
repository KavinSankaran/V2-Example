package org.firstinspires.ftc.teamcode.intoTheDeep.kotlin.subsystems

import com.pedropathing.ivy.Scheduler.schedule
import dev.nextftc.hardware.actuators.NextServo
import dev.nextftc.robot.Mechanism

class Claw : Mechanism {
    val claw = NextServo("claw")

    val open = instant { claw.position = 1.0 }
    val close = instant { claw.position = 0.0 }
}