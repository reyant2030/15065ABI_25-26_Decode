package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Definitions.Intake;
import org.firstinspires.ftc.teamcode.Definitions.Outtake;
import org.firstinspires.ftc.teamcode.Definitions.RightTransfer;

@TeleOp(name = "Test TeleOp")
public class TestTeleOp extends OpMode {
    Intake intake = new Intake();
    RightTransfer rightTransfer = new RightTransfer();
    Outtake outtake = new Outtake();

    @Override
    public void init() {
        intake.initIntake(hardwareMap);
        rightTransfer.initRightTransfer(hardwareMap);
        outtake.initOuttake(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.x) {
            intake.setIntakePower(0.54260869565);
        }
        else {
            intake.setIntakePower(0);
        }

        if (gamepad1.b) {
            outtake.setVelocity(6000);
        }
        else {
            outtake.setVelocity(0);
        }

        if (gamepad1.y) {
            rightTransfer.setRightTransferPower(0.5);
        }
    }
}
