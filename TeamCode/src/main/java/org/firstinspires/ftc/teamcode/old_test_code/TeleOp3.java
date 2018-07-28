package org.firstinspires.ftc.teamcode.old_test_code;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class TeleOp3 extends OpMode{
    private DcMotor FLM;
    private DcMotor FRM;
    private DcMotor BLM;
    private DcMotor BRM;
    private DcMotor flapper;
    private DcMotor thunker;
    private DcMotor lift;
    private Servo gate;
    private Servo arm;
    private boolean slow;
    private boolean right;
    private boolean left;

    @Override

    public void init() {
        FLM = hardwareMap.dcMotor.get("FLM");
        FRM = hardwareMap.dcMotor.get("FRM");
        BLM = hardwareMap.dcMotor.get("BLM");
        BRM = hardwareMap.dcMotor.get("BRM");
        flapper = hardwareMap.dcMotor.get("flapper");
        thunker = hardwareMap.dcMotor.get("thunker");
        lift = hardwareMap.dcMotor.get("lift");

        gate = hardwareMap.servo.get("gate");
        arm = hardwareMap.servo.get("arm");
    }

    @Override
    public void start() {
        /*slow = false;
        right = false;
        left = false;*/

    }

    @Override
    public void loop() {

        arm.setPosition(.1);


        //from here until otherwise stated, the code is for gamepad 2


        flapper.setPower(-gamepad2.left_stick_y);

        if(gamepad2.dpad_up){
            thunker.setPower(-.33);

        }
        else if(gamepad2.dpad_down){
            thunker.setPower(.33);

        }
        else{
            thunker.setPower(0);

        }



        lift.setPower(gamepad2.right_stick_y);

        if (gamepad2.left_bumper){
            lift.setPower(-.15);
        }

        if (gamepad2.dpad_up){
            gate.setPosition (.45);

        }


        else if (gamepad2.dpad_down){
            gate.setPosition(0);

        }


        //from here on the code is for gamepad 1
/*
        if (gamepad1.right_bumper) {
            slow = !slow;

        }
        else if (gamepad1.y) {
            right = !right;
            left = false;
        }
        else if (gamepad1.x) {
            right = false;
            left = !left;
        }*/

/*
        if (right){
            FLM.setPower(-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);
            FRM.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);
            BRM.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);
            BLM.setPower(gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);

        }
        else if (left){
            FLM.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);
            FRM.setPower(gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);
            BRM.setPower(-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);
            BLM.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);

        }
        else {
            FLM.setPower(-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);
            FRM.setPower(gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);
            BRM.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);
            BLM.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);

        }
        if (right && slow){
            FLM.setPower(-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger * .1);
            FRM.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger* .1);
            BRM.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger* .1);
            BLM.setPower(gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger* .1);

        }
        else if (left && slow){
            FLM.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger* .1);
            FRM.setPower(gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger* .1);
            BRM.setPower(-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger* .1);
            BLM.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger* .1);

        }
        else if (slow) {
            FLM.setPower(-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger* .1);
            FRM.setPower(gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger* .1);
            BRM.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger* .1);
            BLM.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger* .1);

        }
        else {
            FLM.setPower(-gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);
            FRM.setPower(gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);
            BRM.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);
            BLM.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);

        }*/

        FLM.setPower(gamepad1.left_stick_y + -gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);
        FRM.setPower(-gamepad1.left_stick_y + -gamepad1.left_stick_x +gamepad1.left_trigger + -gamepad1.right_trigger);
        BRM.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);
        BLM.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.left_trigger + -gamepad1.right_trigger);






        /*
        if (gamepad1.dpad_up||gamepad1.dpad_right||gamepad1.right_bumper){
            FLM.setPower(-1);
        }
        else if(gamepad1.dpad_down||gamepad1.dpad_left||gamepad1.left_bumper){
            FLM.setPower(1);
        }
        if (gamepad1.dpad_up||gamepad1.dpad_left||gamepad1.left_bumper){
            FRM.setPower(1);
        }else if(gamepad1.dpad_down||gamepad1.dpad_right||gamepad1.right_bumper){
            FRM.setPower(-1);
        }
        if (gamepad1.dpad_up||gamepad1.dpad_right||gamepad1.left_bumper){
            BRM.setPower(1);
        }else if(gamepad1.dpad_down||gamepad1.dpad_left||gamepad1.right_bumper){
            BRM.setPower(-1);
        }
        if (gamepad1.dpad_up||gamepad1.dpad_left||gamepad1.right_bumper){
            BLM.setPower(-1);
        }else if(gamepad1.dpad_down||gamepad1.dpad_right||gamepad1.left_bumper){
            BLM.setPower(1);
        }*/

        /*
        if (gamepad1.y){



            if (-gamepad1.left_stick_x > -gamepad1.left_stick_y && -gamepad1.left_stick_x >gamepad1.left_stick_y) {
//right
                FLM.setPower(-gamepad1.left_stick_x);
                FRM.setPower(-gamepad1.left_stick_x);
                BLM.setPower(gamepad1.left_stick_x);
                BRM.setPower(gamepad1.left_stick_x);
            }
//left
            else if (gamepad1.left_stick_x > gamepad1.left_stick_y && gamepad1.left_stick_x >-gamepad1.left_stick_y) {

                FLM.setPower(-gamepad1.left_stick_x);
                FRM.setPower(-gamepad1.left_stick_x);
                BLM.setPower(gamepad1.left_stick_x);
                BRM.setPower(gamepad1.left_stick_x);
            }
            //forward
            else if (gamepad1.left_stick_y > gamepad1.left_stick_x && gamepad1.left_stick_y >-gamepad1.left_stick_x) {

                FLM.setPower(gamepad1.left_stick_y);
                FRM.setPower(-gamepad1.left_stick_y);
                BLM.setPower(gamepad1.left_stick_y);
                BRM.setPower(-gamepad1.left_stick_y);
            }
            //back
            else if (-gamepad1.left_stick_y > -gamepad1.left_stick_x && -gamepad1.left_stick_y >gamepad1.left_stick_x) {

                FLM.setPower(gamepad1.left_stick_y);
                FRM.setPower(-gamepad1.left_stick_y);
                BLM.setPower(gamepad1.left_stick_y);
                BRM.setPower(-gamepad1.left_stick_y);
            }
        }
        //slow trigger


        if (gamepad1.x && -gamepad1.left_stick_x > -gamepad1.left_stick_y && -gamepad1.left_stick_x >gamepad1.left_stick_y) {
//right

            FLM.setPower(gamepad1.left_stick_y);
            FRM.setPower(-gamepad1.left_stick_y);
            BLM.setPower(gamepad1.left_stick_y);
            BRM.setPower(-gamepad1.left_stick_y);
        }
//left
        else if (gamepad1.x && gamepad1.left_stick_x > gamepad1.left_stick_y && gamepad1.left_stick_x >-gamepad1.left_stick_y) {

            FLM.setPower(gamepad1.left_stick_y);
            FRM.setPower(-gamepad1.left_stick_y);
            BLM.setPower(gamepad1.left_stick_y);
            BRM.setPower(-gamepad1.left_stick_y);
        }
        //forward
        else if (gamepad1.x && gamepad1.left_stick_y > gamepad1.left_stick_x && gamepad1.left_stick_y >-gamepad1.left_stick_x) {

            FLM.setPower(-gamepad1.left_stick_x);
            FRM.setPower(-gamepad1.left_stick_x);
            BLM.setPower(gamepad1.left_stick_x);
            BRM.setPower(gamepad1.left_stick_x);
        }
        //back
        else if (gamepad1.x && -gamepad1.left_stick_y > -gamepad1.left_stick_x && -gamepad1.left_stick_y >gamepad1.left_stick_x) {

            FLM.setPower(-gamepad1.left_stick_x);
            FRM.setPower(-gamepad1.left_stick_x);
            BLM.setPower(gamepad1.left_stick_x);
            BRM.setPower(gamepad1.left_stick_x);
        }




        if ( -gamepad1.left_stick_x > -gamepad1.left_stick_y && -gamepad1.left_stick_x >gamepad1.left_stick_y) {
//right
            FLM.setPower(gamepad1.left_stick_x*-.75);
            FRM.setPower(gamepad1.left_stick_x*-.75);
            BLM.setPower(gamepad1.left_stick_x*.75);
            BRM.setPower(gamepad1.left_stick_x*.75);
        }
//left
        else if ( gamepad1.left_stick_x > gamepad1.left_stick_y && gamepad1.left_stick_x >-gamepad1.left_stick_y) {

            FLM.setPower(gamepad1.left_stick_x*-.75);
            FRM.setPower(gamepad1.left_stick_x*-.75);
            BLM.setPower(gamepad1.left_stick_x*.75);
            BRM.setPower(gamepad1.left_stick_x*.75);
        }
        //forward
        else if ( gamepad1.left_stick_y > gamepad1.left_stick_x && gamepad1.left_stick_y >-gamepad1.left_stick_x) {

            FLM.setPower(gamepad1.left_stick_y*.75);
            FRM.setPower(gamepad1.left_stick_y*-.75);
            BLM.setPower(gamepad1.left_stick_y*.75);
            BRM.setPower(gamepad1.left_stick_y*-.75);
        }
        //back
        else if ( -gamepad1.left_stick_y > -gamepad1.left_stick_x && -gamepad1.left_stick_y >gamepad1.left_stick_x) {

            FLM.setPower(gamepad1.left_stick_y*.75);
            FRM.setPower(gamepad1.left_stick_y*-.75);
            BLM.setPower(gamepad1.left_stick_y*.75);
            BRM.setPower(gamepad1.left_stick_y*-.75);
        }

        else if (gamepad1.right_bumper) {

            FLM.setPower(-.5);
            FRM.setPower(-.5);
            BLM.setPower(-.5);
            BRM.setPower(-.5);
        }
        else if (gamepad1.left_bumper) {

            FLM.setPower(.5);
            FRM.setPower(.5);
            BLM.setPower(.5);
            BRM.setPower(.5);
        }
        else {
            FRM.setPower(0);
            BRM.setPower(0);
            FLM.setPower(0);
            BLM.setPower(0);
        }*/


    }
}



        /* FLM.setPower(gamepad1.left_stick_y);
        FLM.setPower(gamepad1.left_stick_x);
        FRM.setPower(gamepad1.right_stick_y);
        FRM.setPower(gamepad1.right_stick_x);
        BLM.setPower(gamepad1.left_stick_y);
        BLM.setPower(gamepad1.left_stick_x);
        BRM.setPower(gamepad1.right_stick_y);
        BRM.setPower(gamepad1.right_stick_x);*/

