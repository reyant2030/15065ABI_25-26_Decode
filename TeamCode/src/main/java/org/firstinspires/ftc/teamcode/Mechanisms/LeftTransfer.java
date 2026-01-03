package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LeftTransfer {
    private DcMotorEx leftTransferMotor;
    double ticks = 145.1;
    double newTarget;

    public void initLeftTransfer(HardwareMap hwMap) {
        leftTransferMotor = hwMap.get(DcMotorEx.class, "LeftTransferMotor");
        leftTransferMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void setEncoder(double turning) {
        newTarget = ticks/turning;
        leftTransferMotor.setTargetPosition((int)newTarget);
        leftTransferMotor.setTargetPositionTolerance(5);
        leftTransferMotor.setPower(1);
        leftTransferMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }

    public void resetEncoder(){
        leftTransferMotor.setTargetPosition(0);
        leftTransferMotor.setTargetPositionTolerance(2);
        leftTransferMotor.setPower(1);
        leftTransferMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }
}