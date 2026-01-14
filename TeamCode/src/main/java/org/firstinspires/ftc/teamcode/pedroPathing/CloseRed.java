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
    Intake intake = new Intake();
    RightTransfer rightTransfer = new RightTransfer();
    LeftTransfer leftTransfer = new LeftTransfer();
    Outtake outtake = new Outtake();
    private Follower follower;
    private Timer pathTimer, opModeTimer;

    public enum PathState {
        // START POSITION_END POSITION
        // DRIVE > ATTEMPT TO SCORE ARTIFACT

        DRIVE_STARTPOS_SHOOT_POS,

        SHOOT_PRELOAD,

        DRIVE_SHOOT_POS_LEAVE_POS,

        DRIVE_SHOOT_POS_BALL3_POS
    }
    PathState pathState;
    private final Pose startPos = new Pose(123.975, 122.708, Math.toRadians(-144));
    private final Pose shootPos1 = new Pose(86.636, 85.583, Math.toRadians(-138));
    private final Pose leavePos = new Pose(85.583, 116.242, Math.toRadians(85));
    private final Pose ball3Pos = new Pose(122.845,85.907, Math.toRadians(1));
    private PathChain driveStartPosShootPos;
    private PathChain driveShootPosLeavePos;
    private PathChain driverShootPosdriveball3Pos;
    public void buildPaths() {
        driveStartPosShootPos = follower.pathBuilder()
                .addPath(new BezierLine(startPos, shootPos1))
                .setGlobalLinearHeadingInterpolation(startPos.getHeading(), shootPos1.getHeading())
                .build();

        driveShootPosLeavePos = follower.pathBuilder()
                .addPath(new BezierLine(shootPos1, leavePos))
                .setGlobalLinearHeadingInterpolation(shootPos1.getHeading(), leavePos.getHeading())
                .build();

        driverShootPosdriveball3Pos = follower.pathBuilder()
                .addPath(new BezierLine(shootPos1, ball3Pos))
                .setGlobalLinearHeadingInterpolation(shootPos1.getHeading(), ball3Pos.getHeading())
                .build();

    }
    public void statePathUpdate()
    {
        switch (pathState)
        {
            case DRIVE_STARTPOS_SHOOT_POS:
                follower.followPath(driveStartPosShootPos, true);
                 setPathState(PathState.SHOOT_PRELOAD);
                break;

            case DRIVE_SHOOT_POS_BALL3_POS:
            {
                if (!follower.isBusy())
                {
                    telemetry.addLine("Done Leave Auto");
                }
            }

            case SHOOT_PRELOAD:
                if (!follower.isBusy() && pathTimer.getElapsedTimeSeconds() > 5)
                {

                   follower.followPath(driveShootPosLeavePos, true);
                    setPathState(PathState.DRIVE_SHOOT_POS_BALL3_POS);
                   // redo outtake stuff here
                }
                break;

            case DRIVE_SHOOT_POS_LEAVE_POS:
            {
                if (!follower.isBusy())
                {
                telemetry.addLine("Done Leave Auto");
                }
           }
            default:
                telemetry.addLine("No State Comanded");
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
        pathState = PathState.DRIVE_STARTPOS_SHOOT_POS;
        pathTimer = new Timer();
        opModeTimer = new Timer();
        follower = Constants.createFollower(hardwareMap);

        buildPaths();;
        follower.setPose(startPos);
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

//cool comment 4
//cool comment 10
//cool comment 11
//cool comment 12