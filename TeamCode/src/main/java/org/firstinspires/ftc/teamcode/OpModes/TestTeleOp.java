package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.Mechanisms.LeftTransfer;
import org.firstinspires.ftc.teamcode.Mechanisms.Outtake;
import org.firstinspires.ftc.teamcode.Mechanisms.RightTransfer;

@TeleOp(name = "Pls Change")
public class TestTeleOp extends OpMode {
    Intake intake = new Intake();
    RightTransfer rightTransfer = new RightTransfer();
    LeftTransfer leftTransfer = new LeftTransfer();
    Outtake outtake = new Outtake();

    @Override
    public void init() {
        intake.initIntake(hardwareMap);
        rightTransfer.initRightTransfer(hardwareMap);
        leftTransfer.initLeftTransfer(hardwareMap);
        outtake.initOuttake(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.right_bumper) {
            intake.setIntakePower(0.7);
        }

        if (gamepad1.left_bumper) {
            intake.setIntakePower(0);
        }

        if (gamepad1.b) {
            rightTransfer.setRightTransferPower(0.5);
        }

        if (gamepad1.y) {
            rightTransfer.setRightTransferPower(0.5);
        }

        if (gamepad1.dpad_right) {
            rightTransfer.setRightTransferPower(0);
        }


        if (gamepad1.x) {
            leftTransfer.setLeftTransferPower(0.5);
        }

        if (gamepad1.a) {
            leftTransfer.setLeftTransferPower(-0.5);
        }

        if (gamepad1.dpad_left) {
            leftTransfer.setLeftTransferPower(0);
        }

        if (gamepad1.right_trigger > 0.5) {
            outtake.setVelocity(1900);
        }

        if (gamepad1.left_trigger > 0.5) {
            outtake.setVelocity(0);
        }
    }
}
