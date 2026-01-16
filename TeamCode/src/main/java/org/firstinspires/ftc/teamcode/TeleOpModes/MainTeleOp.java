package org.firstinspires.ftc.teamcode.TeleOpModes;
import static android.os.SystemClock.sleep;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Devices.LeftColorSensor;
import org.firstinspires.ftc.teamcode.Devices.RightColorSensor;
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
    RightColorSensor rightColorSensor = new RightColorSensor();
    LeftColorSensor leftColorSensor = new LeftColorSensor();
    Outtake outtake = new Outtake();

    @Override
    public void init() {
        drivetrain.initDrivetrain(hardwareMap);
        intake.initIntake(hardwareMap);
        rightTransfer.initRightTransfer(hardwareMap);
        rightColorSensor.initRightColorSensor(hardwareMap);
        leftColorSensor.initRightColorSensor(hardwareMap);
        leftTransfer.initLeftTransfer(hardwareMap);
        outtake.initOuttake(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;
        drivetrain.drive(forward, strafe, rotate);

        if (gamepad1.right_bumper) {
            intake.setIntakePower(1);
        }
        else if(gamepad1.left_bumper){
            intake.setIntakePower(-1);
        }
        else{
            intake.setIntakePower(0);
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
        else if (gamepad2.dpad_down) {
            leftTransfer.setLeftTransferPower(1);
            sleep(500);
            leftTransfer.setLeftTransferPower(0);
            sleep(1500);
            rightTransfer.setRightTransferPower(1);
            sleep(500);
            rightTransfer.setRightTransferPower(0);
        }

        if (gamepad2.right_trigger > 0.5) {
            rightTransfer.setRightTransferPower(-1);
        }
        else if (gamepad2.left_trigger > 0.5) {
            leftTransfer.setLeftTransferPower(-1);
        }
        else {
            rightTransfer.setRightTransferPower(0);
            leftTransfer.setLeftTransferPower(0);
        }

        if (gamepad2.right_bumper) {
            outtake.setVelocity(1900);
            outtake.getVelocity();
        }
        else if (gamepad2.left_bumper) {
            outtake.setVelocity(1750);
            outtake.getVelocity();
        }
        else {
            outtake.setVelocity(0);
        }
    }
}
// cool comment 14
//