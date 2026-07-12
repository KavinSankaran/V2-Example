package org.firstinspires.ftc.teamcode.util.subsystems

import com.pedropathing.ivy.commands.Commands.waitMs
import com.pedropathing.ivy.groups.Groups.sequential
import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism

class Catapult : Mechanism {
    private val right = NextMotor("right")
    private val left = NextMotor("left").apply { follow(right, NextMotor.Direction.REVERSE) }

    val up = instant { right.setThrottle(1.0) }
    val down = instant { right.setThrottle(-1.0) }
    val slow = instant { right.setThrottle(0.35) }
    val stop = instant { right.setThrottle(0.0) }

    val volt = sequential(up, waitMs(250.0), stop)
    val stabilize = sequential(slow, waitMs(0.0009), down)
}