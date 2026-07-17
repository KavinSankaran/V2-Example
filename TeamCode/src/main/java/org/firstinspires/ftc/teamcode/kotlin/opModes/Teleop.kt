package org.firstinspires.ftc.teamcode.kotlin.opModes

import dev.nextftc.robot.opmode.NextOpMode
import dev.nextftc.robot.opmode.NextTeleop
import dev.nextftc.robot.triggers.CommandGamepad
import dev.nextftc.robot.triggers.Trigger
import org.firstinspires.ftc.teamcode.kotlin.subsystems.Robot

@NextTeleop("teleop_itd_kotlin")
class Teleop(robot: Robot) : NextOpMode(robot) {
    init {
        val gp1 = CommandGamepad(Trigger.defaultEventLoop, gamepad1)
        val gp2 = CommandGamepad(Trigger.defaultEventLoop, gamepad2)

        robot.drivetrain.drive(
            gp1.leftStickY.value,
            gp1.leftStickX.value,
            gp1.rightStickX.value
        )

        gp2.rightBumper
            .toggleOnTrue(robot.slides.up)
            .toggleOnFalse(robot.slides.down)

        gp2.leftBumper.onTrue(robot.slides.middle)

        gp2.y
            .toggleOnTrue(robot.claw.open)
            .toggleOnFalse(robot.claw.close)
    }
}