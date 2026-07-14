package org.firstinspires.ftc.teamcode.opModes

import dev.nextftc.robot.opmode.NextOpMode
import dev.nextftc.robot.opmode.NextTeleop
import dev.nextftc.robot.triggers.CommandGamepad
import dev.nextftc.robot.triggers.Trigger
import org.firstinspires.ftc.teamcode.util.subsystems.Robot

@NextTeleop
class Teleop(robot: Robot) : NextOpMode(robot) {
    init {
        val gp1 = CommandGamepad(Trigger.defaultEventLoop, gamepad1)
        val gp2 = CommandGamepad(Trigger.defaultEventLoop, gamepad2)

    }
}