package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Outtake {
    DcMotorEx outtakeMotor;

    public void initOuttake(HardwareMap hwMap) {
        outtakeMotor = hwMap.get(DcMotorEx.class, "OuttakeMotor");
        outtakeMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        outtakeMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
        outtakeMotor.setVelocityPIDFCoefficients(1200, 0, 0, 14.6322);
    }

    public void getVelocity() {
        outtakeMotor.getVelocity();
    }

    public void setVelocity(double velocity) {
        outtakeMotor.setPower(velocity);
    }
}
