package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.control.FilteredPIDFCoefficients;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.Encoder;
import com.pedropathing.ftc.localization.constants.TwoWheelConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.pedropathing.control.PIDFCoefficients;

public class Constants
{
    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(11.7)
            .forwardZeroPowerAcceleration(-24.35853883383626)
            .lateralZeroPowerAcceleration(-81.93762018577026)
            .translationalPIDFCoefficients(new PIDFCoefficients(0.09, 0, 0.001, 0.02))
            .headingPIDFCoefficients(new PIDFCoefficients(0.8, 0, 0, 0.025))
            .drivePIDFCoefficients(new FilteredPIDFCoefficients(0.0085,0,0.01,0.6,0.00001))
            .centripetalScaling(0.005);
    public static TwoWheelConstants localizerConstants = new TwoWheelConstants()
            .forwardTicksToInches(0.003)
            .strafeTicksToInches(0.003)
            .forwardEncoderDirection(Encoder.FORWARD)
            .strafePodX(Encoder.FORWARD)
            .forwardPodY(-4)
            .strafePodX(-7)
            .forwardEncoder_HardwareMapName("BackLeftMotor")
            .strafeEncoder_HardwareMapName("FrontRightMotor")
            .IMU_HardwareMapName("imu")
            .IMU_Orientation(
                    new RevHubOrientationOnRobot(
                            RevHubOrientationOnRobot.LogoFacingDirection.UP,
                            RevHubOrientationOnRobot.UsbFacingDirection.RIGHT
                    )
            );

    public static MecanumConstants driveConstants = new MecanumConstants()
            .maxPower(1)
            .rightFrontMotorName("FrontRightMotor")
            .rightRearMotorName("BackRightMotor")
            .leftRearMotorName("BackLeftMotor")
            .leftFrontMotorName("FrontLeftMotor")
            .leftFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .leftRearMotorDirection(DcMotorSimple.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorSimple.Direction.FORWARD)
            .xVelocity(39.217195989756235)
            .yVelocity(37.269476913177606);
    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1.25, 1);
    public static Follower createFollower (HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .twoWheelLocalizer(localizerConstants)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .build();
    }
}

