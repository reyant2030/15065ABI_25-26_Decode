package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RightTransfer {
    private DcMotor rightTransferMotor;

    public void initRightTransfer(HardwareMap hwMap) {
        rightTransferMotor = hwMap.get(DcMotor.class, "RightTransferMotor");
        rightTransferMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightTransferMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightTransferMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void setRightTransferPower(double power) {
        rightTransferMotor.setPower(power);
    }
}
//cool comment 5
