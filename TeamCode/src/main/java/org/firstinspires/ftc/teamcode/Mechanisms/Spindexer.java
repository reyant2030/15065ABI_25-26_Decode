package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Spindexer {
    DcMotor spindexerMotor;

    double ticks = 145.5;
    public void initSpindexer(HardwareMap hwMap) {
        spindexerMotor= hwMap.get(DcMotorEx.class, "SpindexerMotor");
        spindexerMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        spindexerMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
    }

    public void setSpindexerPosition(double turning) {

    }
}
