package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.Mechanisms.RightTransfer;

@TeleOp(name = "Pls Change")
public class TestTeleOp extends OpMode {
    Intake intake = new Intake();
    RightTransfer rightTransfer = new RightTransfer();

    @Override
    public void init() {
        intake.initIntake(hardwareMap);
        rightTransfer.initRightTransfer(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.x) {
            intake.setIntakePower(0.7);
        }
        else {
            intake.setIntakePower(0);
        }

        if (gamepad1.a) {
            rightTransfer.setRightTransferPower(0.5);
        }
        else {
            rightTransfer.setRightTransferPower(0);
        }
    }
}
