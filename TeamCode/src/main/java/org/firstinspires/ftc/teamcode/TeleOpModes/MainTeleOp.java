package org.firstinspires.ftc.teamcode.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.Booster;
import org.firstinspires.ftc.teamcode.Mechanisms.Outtake;

@TeleOp(name = "Main TeleOp")
public class MainTeleOp extends OpMode
{
    Outtake outtake = new Outtake();
    Booster booster = new Booster();

    @Override
    public void init()
    {
        outtake.initOuttake(hardwareMap);
        booster.initBooster(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.x)
        {
            outtake.setVelocity(2800);
        }

        if (gamepad1.b)
        {
            booster.setBoosterPower(1);
        }
    }
}
