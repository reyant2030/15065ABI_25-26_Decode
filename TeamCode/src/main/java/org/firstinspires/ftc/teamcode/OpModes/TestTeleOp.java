package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.Mechanisms.Outtake;

@TeleOp(name = "Test TeleOp")
public class TestTeleOp extends OpMode {
    Outtake outtake = new Outtake();

    @Override
    public void init() {
        outtake.initOuttake(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.x) {
            outtake.setVelocity(1900);
        }

        if (gamepad1.b) {
            outtake.setVelocity(1500);
        }
    }
}
