package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Spindexer {
    DcMotorEx spindexerMotor;
    double target;
    double ticks = 145.1;

    public void initSpindexer(HardwareMap hardwareMap) {
        spindexerMotor = hardwareMap.get(DcMotorEx.class, "SpindexerMotor");
        spindexerMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        spindexerMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
        spindexerMotor.setPositionPIDFCoefficients(21);
    }

    public void encoder(double turning) {
        spindexerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        target = ticks/turning;
        spindexerMotor.setTargetPosition((int)target);
        spindexerMotor.setTargetPositionTolerance(3);
        spindexerMotor.setPower(0.5);
        spindexerMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }
}
