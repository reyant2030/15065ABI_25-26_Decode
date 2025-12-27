package org.firstinspires.ftc.teamcode.pedroPathing;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.localization.Encoder;
import com.pedropathing.ftc.localization.constants.TwoWheelConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants();

    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1, 1);

    public static Follower createFollower(HardwareMap hardwareMap)
    {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .twoWheelLocalizer(localizerConstants)
                .forwardEncoderDirection(Encoder.REVERSE)
                .strafeEncoderDirection(Encoder.REVERSE)
                .forwardTicksToInches(1)//change to ticks(2 wheel tuning)
                .build();
    }



    public static TwoWheelConstants localizerConstants = new TwoWheelConstants()
            .forwardEncoder_HardwareMapName("FrontLeftMotor")
            .strafeEncoder_HardwareMapName("BackRightMotor")
            .IMU_HardwareMapName("imu")
            .IMU_Orientation

                    (
                    new RevHubOrientationOnRobot
                            (
                            RevHubOrientationOnRobot.LogoFacingDirection.UP,
                            RevHubOrientationOnRobot.UsbFacingDirection.LEFT
                            )
                    );


}
