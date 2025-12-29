package org.firstinspires.ftc.teamcode.Definitions;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
@Disabled
public class Limelight extends LinearOpMode
{
    private Limelight3A limelight;
    private IMU imu;

    public void runOpMode() throws InterruptedException
    {
        limelight = hardwareMap.get(Limelight3A.class, "Limelight");
        limelight.pipelineSwitch(8);
        imu = hardwareMap.get(IMU.class, "IMU");
        RevHubOrientationOnRobot revHubOrientationOnRobot = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);
        imu.initialize(new IMU.Parameters(revHubOrientationOnRobot));
        waitForStart();

        if (isStopRequested())
        {
            return;
        }
        else
        {
            limelight.start();

            while (opModeIsActive())
            {
                YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();
                limelight.updateRobotOrientation(orientation.getYaw());
                LLResult llResult = limelight.getLatestResult();
                if (llResult != null && llResult.isValid())
                {
                    Pose3D botPose = llResult.getBotpose();
                    telemetry.addData("Tx", llResult.getTx());
                    telemetry.addData("Ty", llResult.getTy());
                    telemetry.addData("Ta", llResult.getTa());
                }
            }
        }
    }
}