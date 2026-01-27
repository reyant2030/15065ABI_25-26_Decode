package org.firstinspires.ftc.teamcode.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Mechanisms.Booster;
import org.firstinspires.ftc.teamcode.Mechanisms.Drivetrain;
import org.firstinspires.ftc.teamcode.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.Mechanisms.Outtake;
import org.firstinspires.ftc.teamcode.Mechanisms.Transfer;

@TeleOp(name = "Main TeleOp")
public class MainTeleOp extends OpMode {
    Drivetrain drivetrain = new Drivetrain();
    double forward, strafe, rotate;
    Intake intake = new Intake();
    Transfer transfer = new Transfer();
    Booster booster = new Booster();
    Outtake outtake = new Outtake();

    public DcMotorEx spindexerMotor;
    double ticks = 145.1;
    double target;

    @Override
    public void init() {
        drivetrain.initDrivetrain(hardwareMap);
        intake.initIntake(hardwareMap);
        transfer.initTransfer(hardwareMap);
        booster.initBooster(hardwareMap);
        outtake.initOuttake(hardwareMap);

        spindexerMotor= hardwareMap.get(DcMotorEx.class, "SpindexerMotor");
        spindexerMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        spindexerMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
        spindexerMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
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

        if (gamepad1.dpad_up) {
            encoder();
        }

        if (gamepad1.x) {
            transfer.setTransferPosition(0.8);
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
            outtake.setOuttakeVelocity(1300);
        }
        else {
            outtake.setOuttakeVelocity(0);
        }
    }

    public void encoder() {
        spindexerMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        target += 48.3666666667;
        spindexerMotor.setTargetPosition((int)target);
        spindexerMotor.setTargetPositionTolerance(5);
        spindexerMotor.setPower(0.5);
        spindexerMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }
}