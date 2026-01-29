package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Transfer {
    Servo transferServo;

    public void initTransfer(HardwareMap hwMap) {
        transferServo = hwMap.get(Servo.class, "TransferServo");
    }

    public void setTransferPosition(double position) {
        transferServo.setPosition(position);
    }
}
