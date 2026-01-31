/* package org.firstinspires.ftc.teamcode.Devices;

import org.firstinspires.ftc.robotcore.internal.collections.CircularIntBuffer;

import java.util.Timer;

public class PDFL {
    private double kP, kD, kF, kL;
    private Timer timer = new Timer();
    private <Double> timeBuffer = new (3,0 );
    private <Double> errorBuffer = new (3, 0);

    public PDFL(double kP, double kD, double kF, double kL) {
        this.kP = kP;
        this.kD = kD;
        this.kF = kF;
        this.kL = kL;
    }

    public double run(double error) {
        double p = pComponent();
        double d = dComponent();
        double f = fComponent();
        double l = lComponent();

        double response = p + d + f + l;

        return response;
    }

    private double pComponent(double error) {
        double response = kP * error;

        return response;
    }

    private double dComponent(double delta_error, double delta_time) {
        double derivative = delta_error / delta_time;

        double response = derivative * kD;

        return 0;
    }

    private double fComponent(){
        double response = kF;

        return response;
    }

    private double lComponent(double error) {
        double direction = Math.signum(error);

        double response = direction * kL;

        return 0;
    }
} */
