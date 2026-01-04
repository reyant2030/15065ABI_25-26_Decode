package org.firstinspires.ftc.teamcode.OpModes;

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
        strafe = gamepad1.right_stick_x;
        rotate = gamepad1.left_stick_x;
        drivetrain.drive(forward, strafe, rotate);


    }
}
