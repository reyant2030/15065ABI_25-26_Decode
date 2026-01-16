package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.util.Timer;

import org.firstinspires.ftc.teamcode.Mechanisms.Intake;
import org.firstinspires.ftc.teamcode.Mechanisms.LeftTransfer;
import org.firstinspires.ftc.teamcode.Mechanisms.Outtake;
import org.firstinspires.ftc.teamcode.Mechanisms.RightTransfer;
@Autonomous
public class CloseRed extends OpMode
{

    private Follower follower;
    private Timer pathTimer, opModeTimer;

    public enum PathState
    {
        // START POSITION END POSITION
        // DRIVE > MOVEMENT STATE
        // SHOOT > ATTEMPT TO SCORE THE ARTIFACT

        DRIVE_STARTPOS_CLOSESHOOTPOS,

        SHOOT_PRELOAD
    }

    PathState pathState;

    private final Pose startPose = new Pose(124.32298136645963,122.53416149068322, Math.toRadians(-141));
    private final Pose closeShootPos = new Pose(86.18633540372672,85.639751552795, Math.toRadians(-138));
    private PathChain driveStartPoseCloseShootPose;

    public void buildPaths()
    {
        driveStartPoseCloseShootPose = follower.pathBuilder()
                .addPath(new BezierLine(startPose, closeShootPos))
                .setLinearHeadingInterpolation(startPose.getHeading(), closeShootPos.getHeading())
                .build();
    }

    public void statePathUpdate()
    {
        switch(pathState)
        {
            case DRIVE_STARTPOS_CLOSESHOOTPOS:
                follower.followPath(driveStartPoseCloseShootPose, true);
                setPathState(PathState.SHOOT_PRELOAD);
                break;

            case SHOOT_PRELOAD:
                //flywheel logic
                if(!follower.isBusy())
                {
                    //flywheel logic
                    telemetry.addLine("Done Path 1");
                }
                break;

            default:
                telemetry.addLine("No State Commanded");
                break;
        }
    }

    public void setPathState(PathState newState)
    {
         pathState = newState;
         pathTimer.resetTimer();
    }
    @Override
    public void init()
    {
        pathState = PathState.DRIVE_STARTPOS_CLOSESHOOTPOS;
        pathTimer = new Timer();
        opModeTimer.resetTimer();
        follower = Constants.createFollower(hardwareMap);

        buildPaths();
        follower.setPose(startPose);
    }

    @Override
    public void start()
    {
         opModeTimer.resetTimer();
         setPathState(pathState);
    }

    @Override
    public void loop()
    {
        follower.update();
        statePathUpdate();
        telemetry.addData("path state", pathState.toString());
        telemetry.addData("x", follower.getPose().getX());
        telemetry.addData("y", follower.getPose().getY());
        telemetry.addData("heading", follower.getPose().getHeading());
        telemetry.addData("Path time", pathTimer.getElapsedTimeSeconds());
    }
}