package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    DcMotorEx intake;
    enum IntakeStates{
        INTAKE,
        OUTAKE,
        OFF,
    }
    IntakeStates intakeState = IntakeStates.OFF;
    public void intakeTasks(){
        switch(intakeState){
            case OFF:
                intake.setPower(0);
                break;
            case INTAKE:
                intake.setPower(1);
                break;
            case OUTAKE:
                intake.setPower(-1);
                break;
        }
    }

    public void setIntakeState(IntakeStates intakeState){
        this.intakeState = intakeState;
    }
    public Intake(HardwareMap hwMap){
        intake = hwMap.get(DcMotorEx.class, "intake");
        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intake.setDirection(DcMotorSimple.Direction.FORWARD);
        intake.setPower(0);
    }

}
