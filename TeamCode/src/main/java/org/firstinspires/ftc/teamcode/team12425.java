package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by angel on 1/28/2018.
 */
@TeleOp(name = "12425" , group = "12425")
public class team12425 extends LinearOpMode
{
    private DcMotor motorFrontLeft;
    private DcMotor motorFrontRight;
    private DcMotor motorBackLeft;
    private DcMotor motorBackRight;

   private Servo leftArm;
    private Servo rightArm;
    private Servo lift1;
    private Servo lift2;
    private Servo armExt;

   private  static final double ARM_RETRACTED_POSITION = 0.2;
    private  static final double ARM_EXTENDED_POSITION = 0.8;

    @Override
    public void runOpsMode () throws  InterruptedException
    {
        motorFrontLeft = hardwareMap.dcMotor.get ("motorFrontLeft");
        motorFrontRight = hardwareMap.dcMotor.get ("motorFrontRight");
        motorBackLeft = hardwareMap.dcMotor.get ("motorBackLeft");
        motorBackRight = hardwareMap.dcMotor.get ("motorBackRight");

        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
        motorBackLeft.setDirection(DcMotor.Direction.REVERSE);

        leftArm = hardwareMap.servo.get ("leftArm");
        rightArm = hardwareMap.servo.get ("rightArm");

        leftArm.setDirection(Servo.Direction.REVERSE);

        lift1 = hardwareMap.servo.get("lift1");
        lift2 = hardwareMap.servo.get("lift2");

        armExt = hardwareMap.servo.get("armExt");

        waitForStart();

        while (opModeIsActive())
        {
            motorFrontLeft.setPower(-gamepad1.left_stick_y);
            motorBackLeft.setPower(-gamepad1.left_stick_y);

            motorFrontRight.setPower(-gamepad1.right_stick_y);
            motorBackRight.setPower(-gamepad1.right_stick_y);

            if (gamepad2.a)
            {
                leftArm.setPosition(ARM_EXTENDED_POSITION);
                rightArm.setPosition(ARM_EXTENDED_POSITION);
            }

            if (gamepad2.b)
            {
                leftArm.setPosition(ARM_RETRACTED_POSITION);
                rightArm.setPosition(ARM_RETRACTED_POSITION);
            }

            if (gamepad2.left_stick_y > 0)
            {
                lift1.setPosition(0.5);
                lift2.setPosition(0.5);
            }

            if (gamepad2.left_stick_y < 0)
            {
                lift1.setPosition(0.2);
                lift2.setPosition(0.2);
            }

            if (gamepad2.x)
            {
                armExt.setPosition(0.5);
            }

            if (gamepad2.y)
            {
                armExt.setPosition(0.2);
            }


            idle();
        }
    }

}