package org.firstinspires.ftc.teamcode.TeleOpModes;
import static android.os.SystemClock.sleep;

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
        forward = gamepad1.left_stick_y;
        strafe = -gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;
        drivetrain.drive(forward, strafe, rotate);

        if (gamepad1.right_bumper) {
            intake.setIntakePower(1);
        }
        else {
            intake.setIntakePower(0);
        }

        if (gamepad2.a) {
            leftTransfer.setLeftTransferPower(-1);
        }

        if (gamepad2.dpad_down) {
            leftTransfer.setLeftTransferPower(0);
        }

        if (gamepad2.y) {
            rightTransfer.setRightTransferPower(-1);
        }

        if (gamepad2.dpad_up) {
            rightTransfer.setRightTransferPower(0);
        }

        if (gamepad2.x) {
            rightTransfer.setRightTransferPower(0.7);
        }
        else {
            rightTransfer.setRightTransferPower(0);
        }

        if (gamepad2.b) {
            leftTransfer.setLeftTransferPower(0.7);
        }
        else {
            leftTransfer.setLeftTransferPower(0);
        }

        if (gamepad2.right_bumper) {
            outtake.setVelocity(1850);
            outtake.getVelocity();
        }

        else if (gamepad2.left_bumper) {
            outtake.setVelocity(2000);
            outtake.getVelocity();
        }
        else {
            outtake.setVelocity(0);
        }

        if (gamepad2.dpad_up) {
            rightTransfer.setRightTransferPower(1);
            sleep(500);
            rightTransfer.setRightTransferPower(0);
            sleep(1500);
            leftTransfer.setLeftTransferPower(1);
            sleep(500);
            leftTransfer.setLeftTransferPower(0);
        }
    }
}
// cool comment 13