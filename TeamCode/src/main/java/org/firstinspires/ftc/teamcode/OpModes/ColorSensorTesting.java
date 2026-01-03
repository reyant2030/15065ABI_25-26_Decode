package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Devices.RightColorSensor;

public class ColorSensorTesting extends OpMode {
    RightColorSensor rightColorSensor = new RightColorSensor();

    @Override
    public void init() {
        rightColorSensor.initRightColorSensor(hardwareMap);
    }

    @Override
    public void loop() {
        rightColorSensor.getDetectedColor(telemetry);
    }
}
