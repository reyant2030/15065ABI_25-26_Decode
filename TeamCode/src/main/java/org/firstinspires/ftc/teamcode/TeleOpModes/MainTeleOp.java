package org.firstinspires.ftc.teamcode.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.Drivetrain;
import org.firstinspires.ftc.teamcode.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.Mechanisms.LeftTransfer;
import org.firstinspires.ftc.teamcode.Mechanisms.Outtake;
import org.firstinspires.ftc.teamcode.Mechanisms.RightTransfer;

@TeleOp(name = "Main TeleOp")
public class MainTeleOp extends OpMode {
    Drivetrain drivetrain = new Drivetrain();
    double forward, strafe, rotate;

    Intake intake = new Intake();
    RightTransfer rightTransfer = new RightTransfer();
    LeftTransfer leftTransfer = new LeftTransfer();
    Outtake outtake = new Outtake();

    boolean intakeOn = false;
    boolean outtakeOn = false;

    boolean lastRightBumper1 = false;
    boolean lastLeftBumper1 = false;

    @Override
    public void init() {
        drivetrain.initDrivetrain(hardwareMap);
        intake.initIntake(hardwareMap);
        rightTransfer.initRightTransfer(hardwareMap);
        leftTransfer.initLeftTransfer(hardwareMap);
        outtake.initOuttake(hardwareMap);
    }

    @Override
    public void loop() { 
        forward = -gamepad1.right_stick_y;
        strafe = gamepad1.right_stick_x * 1.1;
        rotate = gamepad1.left_stick_x;
        drivetrain.drive(forward, strafe, rotate);

        boolean currentRightBumper = gamepad1.right_bumper;

        if (currentRightBumper && !lastRightBumper1) {
            intakeOn = !intakeOn;
            if (intakeOn) {
                intake.setIntakePower(0.6);
            }
            else {
                intake.setIntakePower(0);
            }
        }
        lastRightBumper1 = currentRightBumper;

        if (gamepad1.a) {
            leftTransfer.setLeftTransferPower(-1);
        }

        if (gamepad1.dpad_down) {
            leftTransfer.setLeftTransferPower(0);
        }

        if (gamepad1.y) {
            rightTransfer.setRightTransferPower(-1);
        }

        if (gamepad1.dpad_up) {
            rightTransfer.setRightTransferPower(0);
        }

        if (gamepad1.b) {
            rightTransfer.setRightTransferPower(0.7);
        }
        else {
            rightTransfer.setRightTransferPower(0);
        }

        if (gamepad1.x) {
            leftTransfer.setLeftTransferPower(0.7);
        }
        else {
            leftTransfer.setLeftTransferPower(0);
        }

        if (gamepad1.left_bumper) {
            outtake.setOuttakePower(0.56);
        }
        else {
            outtake.setOuttakePower(0);
        }
    }
}
