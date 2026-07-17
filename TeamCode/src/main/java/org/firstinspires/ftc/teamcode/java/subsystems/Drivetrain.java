package org.firstinspires.ftc.teamcode.java.subsystems;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Drivetrain implements Mechanism {
    private final NextMotor lf = new NextMotor("lf");
    private final NextMotor lb = new NextMotor("lb");
    private final NextMotor rf = new NextMotor("rf");
    private final NextMotor rb = new NextMotor("rb");

    public Drivetrain() {
        lb.setDirection(NextMotor.Direction.REVERSE);
        rb.setDirection(NextMotor.Direction.REVERSE);
    }

    public Command drive(double x, double y, double rx) {
        return infinite(() -> {
            double denominator = Math.max(Math.abs(x) + Math.abs(y) + Math.abs(rx), 1.0);

            lf.setThrottle((y + x + rx) / denominator);
            lb.setThrottle((y + x + rx) / denominator);
            rf.setThrottle((y - x + rx) / denominator);
            rb.setThrottle((y - x + rx) / denominator);
        });
    }
}
