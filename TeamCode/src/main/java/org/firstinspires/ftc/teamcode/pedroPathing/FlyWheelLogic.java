package org.firstinspires.ftc.teamcode.pedroPathing;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.sun.tools.javac.tree.DCTree;

public class FlyWheelLogic
{
    private DcMotor intakeMotor;

    public void initIntake(HardwareMap hwMap)
    {
        intakeMotor = hwMap.get(DcMotor.class, "IntakeMotor");
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intakeMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void setIntakePower(double power)
    {
        intakeMotor.setPower(power);
    }

    private DcMotor rightTransferMotor;

    public void initRightTransfer(HardwareMap hwMap)
    {
        rightTransferMotor = hwMap.get(DcMotor.class, "RightTransferMotor");
        rightTransferMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightTransferMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightTransferMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void setRightTransferPower(double power)
    {
        rightTransferMotor.setPower(power);
    }
    private DcMotorEx leftTransferMotor;
    public void initLeftTransfer(HardwareMap hwMap)
    {
        leftTransferMotor = hwMap.get(DcMotorEx.class, "LeftTransferMotor");
        leftTransferMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        leftTransferMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        leftTransferMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void setLeftTransferPower(double power)
    {
        leftTransferMotor.setPower(power);
    }

    DcMotorEx outtakeMotor;

    public void initOuttake(HardwareMap hwMap)
    {
        outtakeMotor = hwMap.get(DcMotorEx.class, "OuttakeMotor");
        outtakeMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        outtakeMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
        outtakeMotor.setVelocityPIDFCoefficients(1200, 0, 0, 14.6322);
    }

    public void getVelocity()
    {
        outtakeMotor.getVelocity();
    }

    public void setVelocity(double velocity)
    {
        outtakeMotor.setPower(velocity);
    }

    private ElapsedTime stateTimer = new ElapsedTime();

    private enum FlywheelState
    {
        IDEAL,

        INTAKE,

        STOPINTAKE,

        LEFTTRANSFER,

        STOPLEFTTRANSFER,
        RIGHTTRANSFER,

        STOPRIGHTTRANSFER,

        OUTTAKE,

        STOPOUTTAKE,

    }

    private FlywheelState flywheelState;
    private int shotsRemaining = 0;

    public void update()
    {
        switch (flywheelState)
        {
            case IDEAL:
                if (shotsRemaining > 0)
                {
                    intakeMotor.setPower(0);
                    rightTransferMotor.setPower(0);
                    leftTransferMotor.setPower(0);
                    outtakeMotor.setVelocity(0);

                    stateTimer.reset();
                }
                break;

            case INTAKE:
            {
                intakeMotor.setPower(1);
            }
            break;

            case STOPINTAKE:
            {
                intakeMotor.setPower(0);
            }
            break;

            case RIGHTTRANSFER:
            {
                rightTransferMotor.setPower(1);
            }
            break;

            case STOPRIGHTTRANSFER:
            {
                rightTransferMotor.setPower(0);
            }
            break;
            case STOPLEFTTRANSFER:
            {
                leftTransferMotor.setPower(0);
            }
            break;
            case LEFTTRANSFER:
            {
                intakeMotor.setPower(1);
            }
            break;

            case OUTTAKE:
            {
                outtakeMotor.setVelocity(1570);
            }
            break;

            case STOPOUTTAKE:
            {
                outtakeMotor.setVelocity(0);
            }
            break;
        }



    }
}
