package org.firstinspires.ftc.robotcontroller.internal.old_test_code;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Keith Harder on 1/16/2018.
 */
@Autonomous(name="BlueBall2", group="Auto1")
public class BlueBall2 extends LinearOpMode {

    private DcMotor FLM;
    private DcMotor FRM;
    private DcMotor BLM;
    private DcMotor BRM;
    private DcMotor flapper;
    private DcMotor thunker;
    private DcMotor lift;

    private Servo gate;
    private Servo arm;
    private Servo finger;

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
        finger = hardwareMap.servo.get("finger");

        color = hardwareMap.get(ColorSensor.class, "color");
        color.enableLed(true);

        red = false;
        blue = false;

        arm.setPosition(.6);

//init
        waitForStart();
//??



        gate.setPosition(.8);
        time.reset();
        while (opModeIsActive() && time.seconds() <1){

        }
        arm.setPosition(.97);
        finger.setPosition(.25);
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

        time.reset();
        while (opModeIsActive() && time.seconds() <1 && red){
            /*FRM.setPower(-.5);
            FLM.setPower(-.5);
            BRM.setPower(.5);
            BLM.setPower(.5);*/
            finger.setPosition(.6);

        }

        time.reset();
        while (opModeIsActive() && time.seconds() <1 && blue){
            /*FRM.setPower(1);
            FLM.setPower(1);
            BRM.setPower(-1);
            BLM.setPower(-1);*/
            finger.setPosition(0);

        }
        finger.setPosition(.55);
        arm.setPosition(.6);
        time.reset();
        while (opModeIsActive() && time.seconds() <.5){
            FRM.setPower(1);
            FLM.setPower(1);
            BRM.setPower(-1);
            BLM.setPower(-1);
        }

        time.reset();
        while (opModeIsActive() && time.seconds() <1.2){
            FRM.setPower(-.5);
            FLM.setPower(-.5);
            BRM.setPower(-.5);
            BLM.setPower(-.5);
        }

        time.reset();

        while (opModeIsActive() && time.seconds() <.3){
            FRM.setPower(.5);
            FLM.setPower(.5);
            BRM.setPower(-.5);
            BLM.setPower(-.5);
        }
        FRM.setPower(0);
        FLM.setPower(0);
        BRM.setPower(0);
        BLM.setPower(0);
        time.reset();
        while (opModeIsActive() && time.seconds() <1){

            gate.setPosition(1);

        }
        time.reset();
        while (opModeIsActive() && time.seconds() <1){
            thunker.setPower(-.33);


        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.5){
            FLM.setPower(1);
            FRM.setPower(-1);
            BLM.setPower(1);
            BRM.setPower(-1);
            thunker.setPower(0);

        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.5){
            FLM.setPower(-.5);
            FRM.setPower(.5);
            BLM.setPower(-.5);
            BRM.setPower(.5);



        }
        FRM.setPower(0);
        FLM.setPower(0);
        BRM.setPower(0);
        BLM.setPower(0);
        time.reset();
        while (opModeIsActive() && time.seconds() <1){
            thunker.setPower(.33);

            lift.setPower(-1);
        }
        time.reset();
        while (opModeIsActive() && time.seconds() <1){

            lift.setPower(-1);


        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.2){

            lift.setPower(1);
        }
        lift.setPower(0);


        /*time.reset();
        while (opModeIsActive() && time.seconds() <1){
            FLM.setPower(-1);
            FRM.setPower(-1);
            BLM.setPower(-1);
            BRM.setPower(-1);

        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.65){
            FLM.setPower(1);
            FRM.setPower(1);
            BLM.setPower(1);
            BRM.setPower(1);
        }

        FRM.setPower(0);
        FLM.setPower(0);
        BRM.setPower(0);
        BLM.setPower(0);


        time.reset();
        while (opModeIsActive() && time.seconds() <2){
            flapper.setPower(-1);

        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.8){
            FLM.setPower(-1);
            FRM.setPower(1);
            BLM.setPower(-1);
            BRM.setPower(1);
            flapper.setPower(-1);
        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.8){
            FLM.setPower(1);
            FRM.setPower(-1);
            BLM.setPower(1);
            BRM.setPower(-1);
            flapper.setPower(-1);
        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.8){
            FLM.setPower(-1);
            FRM.setPower(1);
            BLM.setPower(-1);
            BRM.setPower(1);
            flapper.setPower(-1);
        }
        time.reset();
        while (opModeIsActive() && time.seconds() <2.2){
            FLM.setPower(1);
            FRM.setPower(-1);
            BLM.setPower(1);
            BRM.setPower(-1);

        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.3){
            FLM.setPower(-1);
            FRM.setPower(1);
            BLM.setPower(-1);
            BRM.setPower(1);

        }*/


    }
}


