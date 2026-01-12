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

        SHOOT_PRELOAD
    }

    PathState pathState;

    private final Pose startPos = new Pose(124.09316770186336, 123.0869565217391, Math.toRadians(-133));
    private final Pose shootPos = new Pose(70.658, 69.764, Math.toRadians(-133));
    private PathChain driveStartPosShootPos;

    public void buildPaths() {
        driveStartPosShootPos = follower.pathBuilder()
                .addPath(new BezierLine(startPos, shootPos))
                .setGlobalLinearHeadingInterpolation(startPos.getHeading(), shootPos.getHeading())
                .build();
    }

    public void statePathUpdate() {
        switch (pathState)
        {
            case DRIVE_STARTPOS_SHOOT_POS:
                follower.followPath(driveStartPosShootPos, true);
                 setPathState(PathState.SHOOT_PRELOAD);
                break;

            case SHOOT_PRELOAD:
                if (!follower.isBusy())
                {
                    outtake.setOuttakePower(0.53);
                    // leftTransfer.setLeftTransferPower(1);
                    // leftTransfer.setLeftTransferPower(0);
                    // rightTransfer.setRightTransferPower(1);
                    // rightTransfer.setRightTransferPower(0);
                    telemetry.addLine("Done Path 1");
                }
                break;
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
