package org.firstinspires.ftc.teamcode.opModes

import com.pedropathing.ivy.commands.Commands.instant
import com.pedropathing.ivy.commands.Commands.waitMs
import com.pedropathing.ivy.groups.Groups.sequential
import dev.nextftc.robot.opmode.NextOpMode
import dev.nextftc.robot.opmode.NextTeleop
import dev.nextftc.robot.triggers.Trigger
import org.firstinspires.ftc.teamcode.util.subsystems.Robot
import kotlin.math.abs

@NextTeleop("teleop", "test")
class Teleop(robot: Robot) : NextOpMode(robot) {
    init {
        Trigger { robot.intake.artifactCount > 2 }
            .onTrue(
                sequential(
                    robot.intake.reverse,
                    waitMs(500.0),
                    instant(robot.intake::resetCount)
                )
            )

        Trigger { abs(gamepad2.right_stick_y) > 0.01 }
            .whileTrue(robot.intake.custom { gamepad2.right_stick_y })

        Trigger { gamepad2.right_bumper }
            .toggleOnTrue(robot.catapult.volt)
            .toggleOnFalse(robot.catapult.down)

    }
}