package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Spindexer {
    DcMotorEx spindexerMotor;

    double ticks = 145.5;
    public void initSpindexer(HardwareMap hwMap) {
        spindexerMotor= hwMap.get(DcMotorEx.class, "SpindexerMotor");
        spindexerMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        spindexerMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
    }

    public void setSpindexerPosition(double turning) {
        double target = ticks/turning;
        spindexerMotor.setTargetPositionTolerance(5);
        spindexerMotor.setTargetPosition((int)target);
        spindexerMotor.setPower(0.3);
        spindexerMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }
}
