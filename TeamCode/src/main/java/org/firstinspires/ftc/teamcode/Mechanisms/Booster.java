package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Booster {
    private DcMotor boosterMotor;

    public void initBooster(HardwareMap hwMap) {
        boosterMotor = hwMap.get(DcMotor.class, "BoosterMotor");
        boosterMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        boosterMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void setBoosterPower(double power) {
        boosterMotor.setPower(power);
    }
}