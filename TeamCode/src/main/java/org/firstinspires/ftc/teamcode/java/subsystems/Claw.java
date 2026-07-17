package org.firstinspires.ftc.teamcode.java.subsystems;

import static com.pedropathing.ivy.Scheduler.schedule;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.actuators.NextServo;
import dev.nextftc.robot.Mechanism;

public class Claw implements Mechanism {
    private final NextServo claw = new NextServo("claw");

    public Command open = instant(() -> claw.setPosition(1.0));
    public Command close = instant(() -> claw.setPosition(0.0));

    public Claw(){
        schedule(close);
    }
}
