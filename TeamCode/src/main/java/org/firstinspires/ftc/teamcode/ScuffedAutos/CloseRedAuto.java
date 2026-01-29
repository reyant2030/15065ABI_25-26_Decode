package org.firstinspires.ftc.teamcode.ScuffedAutos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Mechanisms.Booster;
import org.firstinspires.ftc.teamcode.Mechanisms.Outtake;
import org.firstinspires.ftc.teamcode.Mechanisms.Spindexer;
import org.firstinspires.ftc.teamcode.Mechanisms.Transfer;

@Autonomous(name = "CloseRedAuto")
public class CloseRedAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor;

        Outtake outtake = new Outtake();
        outtake.initOuttake(hardwareMap);

        Booster booster = new Booster();
        booster.initBooster(hardwareMap);

        Transfer transfer = new Transfer();
        transfer.initTransfer(hardwareMap);

        Spindexer spindexer = new Spindexer();
        spindexer.initSpindexer(hardwareMap);

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

        outtake.setOuttakeVelocity(1300);
        booster.setBoosterPower(0.5);

        frontRightMotor.setPower(-1);
        backRightMotor.setPower(-1);
        frontLeftMotor.setPower(-1);
        backLeftMotor.setPower(-1);
        sleep(700);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        sleep(1000);

        frontRightMotor.setPower(1);
        backRightMotor.setPower(1);
        frontLeftMotor.setPower(-1);
        backLeftMotor.setPower(-1);
        sleep(50);
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        backLeftMotor.setPower(0);
        sleep(1000);

        transfer.setTransferPosition(0.8);
        sleep(500);
        transfer.setTransferPosition(0);
        sleep(500);

        spindexer.encoder(3);

        transfer.setTransferPosition(0.8);
        sleep(500);
        transfer.setTransferPosition(0);
        sleep(500);

        spindexer.encoder(3);

        transfer.setTransferPosition(0.8);
        sleep(500);
        transfer.setTransferPosition(0);
        sleep(500);

        stop();
    }
}

// some comment