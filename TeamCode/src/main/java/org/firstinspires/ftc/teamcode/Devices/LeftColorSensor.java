package org.firstinspires.ftc.teamcode.Devices;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class LeftColorSensor {
    NormalizedColorSensor leftColorSensor;

    public enum DetectedColor {
        Purple,
        Green,
        Unknown
    }

    public void initRightColorSensor(HardwareMap hwMap) {
        leftColorSensor = hwMap.get(NormalizedColorSensor.class, "LeftColorSensor");
        leftColorSensor.setGain(55);
    }

    public DetectedColor getDetectedColor(Telemetry telemetry) {
        NormalizedRGBA colors = leftColorSensor.getNormalizedColors();

        float normRed, normGreen, normBlue;

        normRed = colors.red/ colors.alpha;
        normGreen = colors.green/ colors.alpha;
        normBlue = colors.blue/ colors.alpha;

        telemetry.addData("Red", normRed);
        telemetry.addData("Green", normGreen);
        telemetry.addData("Blue", normBlue);

        return DetectedColor.Unknown;
    }
}