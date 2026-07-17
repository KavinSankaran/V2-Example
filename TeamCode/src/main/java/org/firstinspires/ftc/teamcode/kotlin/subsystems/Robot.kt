package org.firstinspires.ftc.teamcode.kotlin.subsystems

import dev.nextftc.robot.Mechanism
import dev.nextftc.robot.NextRobot

class Robot : NextRobot {
    val claw = Claw()
    val slides = Slides()
    val drivetrain = Drivetrain()

    override val mechanisms: Set<Mechanism>
        get() = setOf(claw, slides, drivetrain)
}