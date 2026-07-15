package org.firstinspires.ftc.teamcode.intoTheDeep.java.opModes;

import org.firstinspires.ftc.teamcode.intoTheDeep.java.subsystems.Robot;

import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;
import dev.nextftc.robot.triggers.Trigger;

@NextTeleop(name = "teleop_itd_java")
public class Teleop extends NextOpMode {
    public Teleop(Robot robot){
        super(robot);

        CommandGamepad gp1 = new CommandGamepad(Trigger.Companion.getDefaultEventLoop(), gamepad1);
        CommandGamepad gp2 = new CommandGamepad(Trigger.Companion.getDefaultEventLoop(), gamepad2);

        gp2.rightBumper()
                .toggleOnTrue(robot.slides.up)
                .toggleOnFalse(robot.slides.down);

        gp2.leftBumper().onTrue(robot.slides.middle);

        gp2.y()
                .toggleOnTrue(robot.claw.open)
                .toggleOnFalse(robot.claw.close);
    }
}
