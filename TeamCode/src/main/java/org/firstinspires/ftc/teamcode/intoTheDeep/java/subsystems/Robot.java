package org.firstinspires.ftc.teamcode.intoTheDeep.java.subsystems;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class Robot implements NextRobot {
    public final Claw claw = new Claw();
    public final Slides slides = new Slides();

    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(claw, slides);
    }
}
