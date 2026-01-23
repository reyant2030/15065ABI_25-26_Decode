package org.firstinspires.ftc.teamcode.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Devices.LeftColorSensor;
import org.firstinspires.ftc.teamcode.Devices.RightColorSensor;
import org.firstinspires.ftc.teamcode.Mechanisms.Drivetrain;
import org.firstinspires.ftc.teamcode.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.Mechanisms.Outtake;

@TeleOp(name = "Main TeleOp")
public class MainTeleOp extends OpMode {
    Drivetrain drivetrain = new Drivetrain();
    double forward, strafe, rotate;

    Intake intake = new Intake();
    RightColorSensor rightColorSensor = new RightColorSensor();
    LeftColorSensor leftColorSensor = new LeftColorSensor();
    Outtake outtake = new Outtake();

    @Override
    public void init() {
        drivetrain.initDrivetrain(hardwareMap);
        intake.initIntake(hardwareMap);
        rightColorSensor.initRightColorSensor(hardwareMap);
        leftColorSensor.initRightColorSensor(hardwareMap);
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

        if (gamepad2.right_bumper) {
            outtake.setVelocity(1900);
        }
        else if (gamepad2.left_bumper) {
            outtake.setVelocity(1750);
        }
        else {
            outtake.setVelocity(0);
        }
    }
}

// Fate was in ABI's favor today