package org.firstinspires.ftc.teamcode.util.subsystems

import com.pedropathing.ivy.commands.Commands.waitMs
import com.pedropathing.ivy.groups.Groups.sequential
import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism

class Catapult : Mechanism {
    val right = NextMotor("launcher")
    val left = NextMotor("launcher2").apply { follow(right, NextMotor.Direction.REVERSE) }

    val up = instant { right.setThrottle(1.0) }
    val down = instant { right.setThrottle(-1.0) }
    val stop = instant { right.setThrottle(0.0) }
    val slow = instant { right.setThrottle(0.35) }

    val volt = sequential(up, waitMs(250.0), stop).requiring(this)
    val stabilize = sequential(slow, waitMs(0.009), down).requiring(this)
}