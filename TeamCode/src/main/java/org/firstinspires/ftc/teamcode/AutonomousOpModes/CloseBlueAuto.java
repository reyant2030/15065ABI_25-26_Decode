package org.firstinspires.ftc.teamcode.AutonomousOpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.Mechanisms.LeftTransfer;
import org.firstinspires.ftc.teamcode.Mechanisms.Outtake;
import org.firstinspires.ftc.teamcode.Mechanisms.RightTransfer;

@Autonomous(name = "CloseAuto")
public class CloseBlueAuto extends LinearOpMode {
    DcMotor frontLeftMotor, frontRightMotor, backRightMotor, backLeftMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        Intake intake = new Intake();
        RightTransfer rightTransfer = new RightTransfer();
        LeftTransfer leftTransfer = new LeftTransfer();
        Outtake outtake = new Outtake();

        rightTransfer.initRightTransfer(hardwareMap);
        leftTransfer.initLeftTransfer(hardwareMap);
        outtake.initOuttake(hardwareMap);

        frontLeftMotor = hardwareMap.get(DcMotor.class, "FrontLeftMotor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "BackLeftMotor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "FrontRightMotor");
        backRightMotor = hardwareMap.get(DcMotor.class, "BackRightMotor");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        outtake.setOuttakePower(0.53);

        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        backRightMotor.setPower(1);
        backLeftMotor.setPower(1);
        frontLeftMotor.setPower(1);
        frontRightMotor.setPower(1);
        sleep(900);
        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        sleep(5000);

        leftTransfer.setLeftTransferPower(1);
        sleep(3000);
        leftTransfer.setLeftTransferPower(0);
        sleep(1000);
        rightTransfer.setRightTransferPower(1);
        sleep(3000);
        rightTransfer.setRightTransferPower(0);
        sleep(3000);

        intake.setIntakePower(0.7);
        rightTransfer.setRightTransferPower(1);
        rightTransfer.setRightTransferPower(1);
        sleep(5000);

        backRightMotor.setPower(1);
        backLeftMotor.setPower(-1);
        frontLeftMotor.setPower(1);
        frontRightMotor.setPower(-1);
        sleep(750);
        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        sleep(3000);

        stop();
    }
}