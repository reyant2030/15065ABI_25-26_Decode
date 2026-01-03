package org.firstinspires.ftc.teamcode.Definitions;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LeftTransfer {
    private DcMotor leftTransferMotor;

    public void initLeftTransfer(HardwareMap hwMap) {
        leftTransferMotor = hwMap.get(DcMotor.class, "LeftTransferMotor");
        leftTransferMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftTransferMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void setLeftTransferPower(double power) {
        leftTransferMotor.setPower(power);
    }
}
