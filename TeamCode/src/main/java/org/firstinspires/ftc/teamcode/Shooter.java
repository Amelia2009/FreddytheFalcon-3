package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {
    DcMotorEx rightSpin;
    DcMotorEx leftSpin;
    public Shooter(HardwareMap hwMap) {
        rightSpin = hwMap.get(DcMotorEx.class, "rightSpin");
        rightSpin.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightSpin.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightSpin.setDirection(DcMotorSimple.Direction.FORWARD);
        rightSpin.setPower(0);

        leftSpin = hwMap.get(DcMotorEx.class, "leftSpin");
        leftSpin.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftSpin.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        leftSpin.setDirection(DcMotorSimple.Direction.FORWARD);
        leftSpin.setPower(0);

    }

    public double getVelocity(){
        return rightSpin.getVelocity();
    }

    public void setVelocity(double targetVelocity){
        rightSpin.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightSpin.setVelocity(targetVelocity);
        leftSpin.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftSpin.setVelocity(targetVelocity);
    }
    public void stopShooting(){
        rightSpin.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightSpin.setPower(0);
        leftSpin.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftSpin.setPower(0);
    }
}
