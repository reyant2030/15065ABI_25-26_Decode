package org.firstinspires.ftc.teamcode.Devices;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IntakeColorSensor {
    NormalizedColorSensor intakeColorSensor;

    public enum DetectedColor {
        Purple,
        Green,
        Unknown
    }

    public void initIntakeColorSensor(HardwareMap hwMap) {
        intakeColorSensor = hwMap.get(NormalizedColorSensor.class, "IntakeColorSensor");
        intakeColorSensor.setGain(55);
    }

    public DetectedColor getDetectedColor(Telemetry telemetry) {
        NormalizedRGBA colors = intakeColorSensor.getNormalizedColors();

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
