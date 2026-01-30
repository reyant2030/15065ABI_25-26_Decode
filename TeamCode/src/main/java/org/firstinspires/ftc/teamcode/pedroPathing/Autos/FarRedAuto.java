package org.firstinspires.ftc.teamcode.pedroPathing.Autos;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.pedropathing.util.Timer;

public class FarRedAuto extends OpMode
{

    private Follower follower;

    private Timer pathTimer, opModeTimer;

    public enum PathState
    {
        // START POSITION_POSITION ONE
        // DRIVE > MOVEMENT STATE
        // SHOOT > ATTEMPT TO SCORE THE ARTIFACT

        DRIVE_STARTPOS_ONEPOS,

        SHOOT_PRELOAD
    }

    PathState pathState;
    private final Pose startPose = new Pose(87.75155279503105,7.776397515527938, Math.toRadians(90));
    private final Pose onePose = new Pose(85.06832298136644,10.062111801242251, Math.toRadians(70));
    @Override
    public void init()
    {
        
    }

    public void loop()
    {

    }

}
