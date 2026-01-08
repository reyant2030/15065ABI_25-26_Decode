package org.firstinspires.ftc.teamcode.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "Velocity Tuner")
@Disabled
public class VelocityTuning extends OpMode {
    public DcMotorEx outtakeMotor;
    double[] stepSizes = {1000.0, 100.0, 10.0, 1.0};
    double velocity = 0;
    int stepIndex = 0;

    @Override
    public void init() {
        outtakeMotor = hardwareMap.get(DcMotorEx.class, "OuttakeMotor");
        outtakeMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {
        double currentVelocity = outtakeMotor.getVelocity();

        if (gamepad1.bWasPressed()) {
            stepIndex = (stepIndex + 1) % stepSizes.length;
        }

        if (gamepad1.dpadLeftWasPressed()) {
            velocity -= stepSizes[stepIndex];
        }

        if (gamepad1.dpadRightWasPressed()) {
            velocity += stepSizes[stepIndex];
        }

        outtakeMotor.setVelocity(velocity);

        telemetry.addData("Current Velocity", "%.2f", currentVelocity);
        telemetry.addData("Tuning Velocity","%.4f (D-Pad L/R)", velocity);
        telemetry.addData("Step Size","%.4f (B Button)", stepSizes[stepIndex]);
    }
}