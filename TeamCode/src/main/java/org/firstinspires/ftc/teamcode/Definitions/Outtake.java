package org.firstinspires.ftc.teamcode.Definitions;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Outtake {
    DcMotorEx outtakeMotor;

    public void initOuttake(HardwareMap hwMap) {
        outtakeMotor = hwMap.get(DcMotorEx.class, "OuttakeMotor");
        outtakeMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        outtakeMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
    }

    public void setOuttakeVelocity(double velocity) {
        outtakeMotor.setVelocity(velocity);
    }
}
