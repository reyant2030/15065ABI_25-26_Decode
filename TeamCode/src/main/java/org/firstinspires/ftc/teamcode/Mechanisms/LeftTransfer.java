package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LeftTransfer {
    private DcMotorEx leftTransferMotor;
    public void initLeftTransfer(HardwareMap hwMap) {
        leftTransferMotor = hwMap.get(DcMotorEx.class, "LeftTransferMotor");
        leftTransferMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        leftTransferMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        leftTransferMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void setLeftTransferPower(double power)
    {
        leftTransferMotor.setPower(power);
    }
}
//cool comment 6