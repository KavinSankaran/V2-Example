package org.firstinspires.ftc.teamcode.util.subsystems

import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.NextRobot

class Robot : NextRobot {
    val intake = Intake()

    override val mechanisms: Set<Mechanism>
        get() = setOf(intake)
}