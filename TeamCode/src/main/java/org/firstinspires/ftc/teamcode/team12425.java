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
   private DcMotor motortopLeft;
    private DcMotor motorbottomLeft
    private DcMotor motortopRight
    private DcMotor motorbottomRight

   private Servo armServo;

   private  static final double ARM_RETRACTED_POSITION = 0.2
    private  static final double ARM_EXTENDED_POSITION = 0.8

    @Override
    public void runOpsMode () throws  InterruptedException
    {
        motorleft = hardwareMap.dcMotor.get ("motorLeft");
        motorRight = hardwareMap.dcMotor.get ("motorRight");

        motorleft.setDirection(DcMotor.Direction.REVERSE);

        armServo = hardwareMap.servo.get ("armServo");

        armServo.setPosition(ARM_RETRACTED_POSITION);


        waitForStart();

        while (opModeIsActive())
        {
            motorleft.setPower(-gamepad1.left_stick_y);
            motorRight.setPower(-gamepad1.right_stick_y);

            if (gamepad2.a)
            {
                armServo.setPosition(ARM_EXTENDED_POSITION);
            }

            if (gamepad2.b)
            {
                armServo.setPosition(ARM_RETRACTED_POSITION);
            }

           idle();
        }
    }

}