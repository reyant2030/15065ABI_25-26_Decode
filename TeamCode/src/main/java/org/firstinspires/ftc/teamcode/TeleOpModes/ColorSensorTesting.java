package org.firstinspires.ftc.teamcode.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Devices.IntakeColorSensor;

@TeleOp(name = "Color Sensor Testing")
public class ColorSensorTesting extends OpMode
{
    IntakeColorSensor intakeColorSensor = new IntakeColorSensor();
    IntakeColorSensor.DetectedColor detectedColor;

    @Override
    public void init()
    {
        intakeColorSensor.initIntakeColorSensor(hardwareMap);
    }

    @Override
    public void loop()
    {
        detectedColor = intakeColorSensor.getDetectedColor(telemetry);
        telemetry.addData("Color Detected", detectedColor);
    }
}
