package org.firstinspires.ftc.teamcode.Devices;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RightColorSensor {
    NormalizedColorSensor rightColorSensor;

    public enum DetectedColor {
        Purple,
        Green,
        White,
        Unknown
    }

    public void initRightColorSensor(HardwareMap hwMap) {
        rightColorSensor = hwMap.get(NormalizedColorSensor.class, "RightColorSensor");
    }

    public DetectedColor getDetectedColor(Telemetry telemetry) {
        NormalizedRGBA colors = rightColorSensor.getNormalizedColors();

        float normRed, normGreen, normBlue;

        normRed = colors.red/ colors.alpha;
        normGreen = colors.green/ colors.alpha;
        normBlue = colors.blue/ colors.alpha;

        telemetry.addData("Red", normRed);
        telemetry.addData("Green", normGreen);
        telemetry.addData("Blue", normBlue);

        /*
         Red =
         Green =
         Blue =
         */

        return DetectedColor.Unknown;
    }
}
