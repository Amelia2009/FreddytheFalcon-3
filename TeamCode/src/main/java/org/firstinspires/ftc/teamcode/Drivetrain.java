package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

//Create a class Drivetrain that has 4 private variables for the hweels, 1 private variable for speed,
// getters and setters for speed variable, a method to drive that sets power to all
// drive motors based on speed parameter (can probably steal from the instance variable) and steal code from gm0 probably
public class Drivetrain {
    private DcMotorEx rf;
    private DcMotorEx lf;
    private DcMotorEx rb;
    private DcMotorEx lb;
    private double speed;

    public Drivetrain(HardwareMap hwMap){
        rf = hwMap.get(DcMotorEx.class, "rf");
        lf = hwMap.get(DcMotorEx.class, "lf");
        rb = hwMap.get(DcMotorEx.class, "rb");
        lb = hwMap.get(DcMotorEx.class, "lb");
        speed = 1;
    }
    public void setSpeed(double speed){
        this.speed = Range.clip(speed, 0, 1);
    }

    public double getSpeed() {
        return speed;
    }
    public void Move(Gamepad gamepad1){
        double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
        double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
        double rx = gamepad1.right_stick_x;

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        lf.setPower(Range.clip(frontLeftPower,-speed, +speed));
        lb.setPower(Range.clip(backLeftPower,-speed, +speed));
        rf.setPower(Range.clip(frontRightPower,-speed, +speed));
        rb.setPower(Range.clip(frontRightPower,-speed, +speed));
    }
}
