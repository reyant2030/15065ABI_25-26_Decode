package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Spindexer {
    DcMotor spindexerMotor;

    double ticks = 145.5;
    public void initSpindexer(HardwareMap hwMap) {
        spindexerMotor= hwMap.get(DcMotor.class, "SpindexerMotor");
        spindexerMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        spindexerMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void setSpindexerPosition(double turning) {
        double target = ticks/turning;
        spindexerMotor.setTargetPosition((int)target);
        spindexerMotor.setPower(0.3);
        spindexerMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}
