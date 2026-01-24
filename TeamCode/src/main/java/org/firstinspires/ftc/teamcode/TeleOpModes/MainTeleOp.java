package org.firstinspires.ftc.teamcode.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Devices.IntakeColorSensor;
import org.firstinspires.ftc.teamcode.Mechanisms.Booster;
import org.firstinspires.ftc.teamcode.Mechanisms.Drivetrain;
import org.firstinspires.ftc.teamcode.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.Mechanisms.Outtake;
import org.firstinspires.ftc.teamcode.Mechanisms.Spindexer;
import org.firstinspires.ftc.teamcode.Mechanisms.Transfer;

@TeleOp(name = "Main TeleOp")
public class MainTeleOp extends OpMode {
    Drivetrain drivetrain = new Drivetrain();
    double forward, strafe, rotate;
    Intake intake = new Intake();
    Spindexer spindexer = new Spindexer();
    Transfer transfer = new Transfer();
    Booster booster = new Booster();
    Outtake outtake = new Outtake();

    @Override
    public void init() {
        drivetrain.initDrivetrain(hardwareMap);
        intake.initIntake(hardwareMap);
        spindexer.initSpindexer(hardwareMap);
        transfer.initTransfer(hardwareMap);
        booster.initBooster(hardwareMap);
        outtake.initOuttake(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;
        drivetrain.drive(forward, strafe, rotate);

        if (gamepad1.right_bumper) {
            intake.setIntakePower(0.54260869565);
        }
        else {
            intake.setIntakePower(0);
        }

        if (gamepad1.dpad_up) {
            spindexer.setSpindexerPosition(3);
        }

        if (gamepad1.x) {
            transfer.setTransferPosition(0.5);
        }
        else {
            transfer.setTransferPosition(0);
        }

        if (gamepad1.a) {
            booster.setBoosterPower(0.5);
        }
        else {
            booster.setBoosterPower(0);
        }

        if (gamepad1.left_bumper) {
            outtake.setOuttakeVelocity(1750);
        }
    }
}