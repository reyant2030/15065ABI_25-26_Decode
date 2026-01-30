package org.firstinspires.ftc.teamcode.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

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

    boolean lastRB = false;
    boolean outtakeOn = false;
    boolean lastA = false;
    boolean boosterOn = false;

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
        forward = -gamepad1.right_stick_y;
        strafe = gamepad1.right_stick_x;
        rotate = gamepad1.left_stick_x;
        drivetrain.drive(forward, strafe, rotate);

        if (gamepad1.right_bumper) {
            intake.setIntakePower(1);
            booster.setBoosterPower(0.5);
        }
        else {
            intake.setIntakePower(0);
            booster.setBoosterPower(0);
        }

        if (gamepad1.left_bumper) {
            intake.setIntakePower(-1);
            booster.setBoosterPower(-0.5);
        }

        if (gamepad2.left_bumper) {
            spindexer.encoder(3);
        }

        if (gamepad2.x) {
            transfer.setTransferPosition(1);
        }
        else {
            transfer.setTransferPosition(0);
        }

        if (gamepad2.a && !lastA) {
            boosterOn = !boosterOn;
        }
        lastA = gamepad2.a;

        if (boosterOn) {
            booster.setBoosterPower(0.5);
        } else {
            booster.setBoosterPower(0);
        }

        if (gamepad2.right_bumper && !lastRB) {
            outtakeOn = !outtakeOn;
        }
        lastRB = gamepad2.right_bumper;

        if (outtakeOn) {
            outtake.setOuttakeVelocity(2000);
        } else {
            outtake.setOuttakeVelocity(0);
        }
    }
}