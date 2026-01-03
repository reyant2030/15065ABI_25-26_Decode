package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RightTransfer {
    private DcMotorEx rightTransferMotor;
    double ticks = 145.1;
    double newTarget;

    public void initRightTransfer(HardwareMap hwMap) {
        rightTransferMotor = hwMap.get(DcMotorEx.class, "RightTransferMotor");
        rightTransferMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void setEncoder(double turning) {
        newTarget = ticks/turning;
        rightTransferMotor.setTargetPosition((int)newTarget);
        rightTransferMotor.setTargetPositionTolerance(5);
        rightTransferMotor.setPower(1);
        rightTransferMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }

    public void resetEncoder(){
        rightTransferMotor.setTargetPosition(0);
        rightTransferMotor.setTargetPositionTolerance(2);
        rightTransferMotor.setPower(1);
        rightTransferMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }
}
