package org.firstinspires.ftc.teamcode.old_test_code;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Keith Harder on 1/16/2018.
 */

public class BallBlockBlue1 extends LinearOpMode {

    private DcMotor FLM;
    private DcMotor FRM;
    private DcMotor BLM;
    private DcMotor BRM;
    private DcMotor flapper;
    private DcMotor thunker;
    private DcMotor lift;

    private Servo gate;
    private Servo arm;

    private ColorSensor color;

    private Boolean red;
    private Boolean blue;

    private ElapsedTime time = new ElapsedTime();
    @Override
    public void runOpMode() throws InterruptedException {
//init
        FLM = hardwareMap.dcMotor.get("FLM");
        FRM = hardwareMap.dcMotor.get("FRM");
        BLM = hardwareMap.dcMotor.get("BLM");
        BRM = hardwareMap.dcMotor.get("BRM");
        flapper = hardwareMap.dcMotor.get("flapper");
        thunker = hardwareMap.dcMotor.get("thunker");
        lift = hardwareMap.dcMotor.get("lift");

        gate = hardwareMap.servo.get("gate");
        arm = hardwareMap.servo.get("arm");

        color = hardwareMap.get(ColorSensor.class, "color");
        color.enableLed(true);

        red = false;
        blue = false;
//init
        waitForStart();
//??


        arm.setPosition(0);
        time.reset();
        while (opModeIsActive() && time.seconds() <3) {
            if (color.red() > color.blue()){
                red = true;
                blue = false;
            }
            else if (color.red() < color.blue()){
                blue = true;
                red = false;
            }

        }
        sleep(3000);

        while (opModeIsActive() && time.seconds() <3 && red){
            flapper.setPower(1);
        }


    }
}
