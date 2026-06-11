package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Transfer {
    DcMotorEx spindexer;
    RevColorSensorV3 color;
    String[] indexBallOrder = {"null", "null", "null"};
    String[] motif = {"green", "green", "purple"};
    int position;

    public Transfer(HardwareMap hwMap) {
        spindexer = hwMap.get(DcMotorEx.class, "spindexer");
        spindexer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        spindexer.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spindexer.setDirection(DcMotorSimple.Direction.FORWARD);
        spindexer.setPower(0);
    }

    public String getColor() {
        int red = color.red();
        int green = color.green();
        int blue = color.blue();

        if (red > 80 && blue > 80 && green < 60) {
            return "purple";
        } else if (red < 100 && blue < 100 && green > 100) {
            return "green";
        } else {
            return "null";
        }
    }
}








