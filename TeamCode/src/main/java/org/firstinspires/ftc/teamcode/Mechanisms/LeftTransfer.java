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

    public void setLeftTransferPower(double power) {
        leftTransferMotor.setPower(power);
    }
}