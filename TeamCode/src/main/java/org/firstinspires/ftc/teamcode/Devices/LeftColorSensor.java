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

        if (normRed > 0.44 && normRed < 0.45 && normGreen > 0.62 && normGreen < 0.64
                && normBlue > 0.73 && normBlue < 0.75)
        {
            return DetectedColor.Purple;
        }

        else if (normRed > 0.43 && normRed < 0.44 && normGreen > 0.93 && normGreen < 0.96
                && normBlue > 0.735 && normBlue < 0.79)
        {
            return DetectedColor.Green;
        }

        /*
         Purple = 1, 1, 1
         Green = 0.5, 1, 1
         */
        return DetectedColor.Unknown;
    }
}