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
        Unknown
    }

    public void initRightColorSensor(HardwareMap hwMap) {
        rightColorSensor = hwMap.get(NormalizedColorSensor.class, "RightColorSensor");
        rightColorSensor.setGain(55);
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

        /* if (normRed > 0.47 && normGreen < 0.77 && normBlue < 0.6)
        {
            return DetectedColor.Purple;
        }

        else if (normRed > 0.32 && normGreen < 0.57 && normBlue < 0.43)
        {
            return DetectedColor.Green;
        } */



        /*
         Purple = 1, 1, 1
         Green = 0.5, 1, 1
         */
        return DetectedColor.Unknown;
    }
}
