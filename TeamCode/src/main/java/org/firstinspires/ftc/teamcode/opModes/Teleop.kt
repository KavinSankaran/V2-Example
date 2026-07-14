package org.firstinspires.ftc.teamcode.opModes

import com.pedropathing.ivy.Scheduler.schedule
import com.pedropathing.ivy.commands.Commands.instant
import com.pedropathing.ivy.commands.Commands.waitMs
import com.pedropathing.ivy.groups.Groups.sequential
import dev.nextftc.robot.opmode.NextOpMode
import dev.nextftc.robot.opmode.NextTeleop
import dev.nextftc.robot.triggers.CommandGamepad
import dev.nextftc.robot.triggers.Trigger
import org.firstinspires.ftc.teamcode.util.subsystems.Robot

@NextTeleop("teleop_test")
class Teleop(robot: Robot) : NextOpMode(robot) {
    init {
        val gp1 = CommandGamepad(Trigger.defaultEventLoop, gamepad1)
        val gp2 = CommandGamepad(Trigger.defaultEventLoop, gamepad2)

        Trigger { robot.intake.artifacts > 3 }.onTrue(
            sequential(
                robot.intake.reverse,
                waitMs(250.0),
                instant(robot.intake::reset)
            )
        )

        schedule(
            robot.drivetrain.drive(
                gp1.leftStickY,
                gp1.rightStickY,
                gp1.rightStickX
            )
        )

        gp2.rightBumper
            .toggleOnTrue(robot.catapult.volt)
            .toggleOnFalse(robot.catapult.down)

        gp2.leftBumper.onTrue(robot.catapult.stabilize)

        gp2.a.onTrue(instant(robot.intake::reset))
    }
}