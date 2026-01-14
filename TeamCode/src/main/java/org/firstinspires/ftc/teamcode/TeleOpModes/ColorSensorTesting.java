package org.firstinspires.ftc.teamcode.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Devices.LeftColorSensor;
import org.firstinspires.ftc.teamcode.Devices.RightColorSensor;

@TeleOp(name = "Color Sensor Testing")
public class ColorSensorTesting extends OpMode
{
    RightColorSensor rightColorSensor = new RightColorSensor();
    RightColorSensor.DetectedColor detectedColor;
    LeftColorSensor leftColorSensor = new LeftColorSensor();
    LeftColorSensor.DetectedColor detectedColor2;

    @Override
    public void init()
    {
        rightColorSensor.initRightColorSensor(hardwareMap);
    }

    @Override
    public void loop()
    {
        detectedColor = rightColorSensor.getDetectedColor(telemetry);
        telemetry.addData("Color Detected", detectedColor);

        detectedColor2 = leftColorSensor.getDetectedColor(telemetry);
        telemetry.addData("Other Color Detected", detectedColor2);
    }
}
