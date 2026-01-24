package org.firstinspires.ftc.teamcode.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.Booster;
import org.firstinspires.ftc.teamcode.Mechanisms.Outtake;
import org.firstinspires.ftc.teamcode.Mechanisms.Spindexer;
import org.firstinspires.ftc.teamcode.Mechanisms.Transfer;

@TeleOp(name = "Test TeleOp ")
public class TestTeleOp extends OpMode {
    Spindexer spindexer = new Spindexer();
    Booster booster = new Booster();
    Transfer transfer = new Transfer();

    @Override
    public void init() {
        spindexer.initSpindexer(hardwareMap);
        booster.initBooster(hardwareMap);
        transfer.initTransfer(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.b) {
            booster.setBoosterPower(0.5);
        }

        if (gamepad1.x) {
            spindexer.setSpindexerPosition(2);
        }

        if (gamepad1.a) {
            transfer.setTransferPosition(0.5);
        }
    }
}
