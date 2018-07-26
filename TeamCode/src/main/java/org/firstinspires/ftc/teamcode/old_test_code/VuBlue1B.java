package org.firstinspires.ftc.teamcode.old_test_code;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by Keith Harder on 1/16/2018.
 */
@Autonomous(name="VuBlue1B", group="Auto1")
public class VuBlue1B extends LinearOpMode {


    public static final String TAG = "Vuforia VuMark Sample";

    OpenGLMatrix lastLocation = null;

    /**
     * {@link #vuforia} is the variable we will use to store our instance of the Vuforia
     * localization engine.
     */
    VuforiaLocalizer vuforia;

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
    private ColorSensor Lcolor;
    private ColorSensor Rcolor;
    private ColorSensor Block;
    //private OpticalDistanceSensor ods;

    private Boolean red;
    private Boolean blue;
    private Boolean left;
    private Boolean right;
    private Boolean center;
    private Boolean NoColor;
    private Boolean NoBlock;
    private Boolean NotSq;
    private Boolean rc;
    private Boolean lc;
    private Boolean done;
    private int AmbLight;

    private ElapsedTime time = new ElapsedTime();
    private ElapsedTime atime = new ElapsedTime();



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
        Lcolor = hardwareMap.get(ColorSensor.class, "Lcolor");
        Lcolor.enableLed(true);
        Rcolor = hardwareMap.get(ColorSensor.class, "Rcolor");
        Rcolor.enableLed(true);
        Block = hardwareMap.get(ColorSensor.class, "block");
        Block.enableLed(true);
        //ods = hardwareMap.opticalDistanceSensor.get("ods");

        red = false;
        blue = false;
        NoColor = true;
        NoBlock = true;
        NotSq = true;
        lc = false;
        rc = false;
        done = false;

        arm.setPosition(.6);


        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "AXk8m93/////AAAAmSo/yH0caUMsqpjNljWxJF8YX6vQ0htlGYE6tx1nTRyclEBgdBc6yxK8FcCcBaKOJ4vuWvJSuv7t5CMUEA9Zo0NrKut9gg+VZovv+S1NoSnG7aQHhCTaDTlhaZ12MRnRxbkEj72yfSdQhZRbT+MGJ7pBGnvWtOSH/YmeK6bffeICGgdjZz9PoHg8AuWBMvWu6vezXnbAX4IzX1KTmQs8KU2ylFsNRzNhErlnZwDw4vTqRPhk6hhKVOV4iaQup/2CgY7fwblJIV/xKhJMMr7GYi8FPDlYctv4dAONrCPqUOLY0MqxhKf++TqI/kNC+kL8Xa/koNY6Cg+2LT9QEn5J819YnhtcwMzIoHzIRPb/j7NM";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");


//init
        waitForStart();

        relicTrackables.activate();

        //if (ods.getLightDetected()<=.1)






        gate.setPosition(.8);
        time.reset();
        while (opModeIsActive() && time.seconds() <1){

        }
        arm.setPosition(.97);
        finger.setPosition(.25);
        time.reset();
        while (opModeIsActive() && time.seconds() <1) {
            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);

            telemetry.addData("VuMark", "%s visible", vuMark);
            telemetry.update();

            if (color.red() > color.blue()){
                red = true;
                blue = false;
            }
            else if (color.red() < color.blue()){
                blue = true;
                red = false;
            }
            if (vuMark.equals(RelicRecoveryVuMark.RIGHT) ) {
                right = true;
                left = false;
                center = false;
            }
            else if (vuMark.equals(RelicRecoveryVuMark.CENTER) ) {
                right = false;
                left = false;
                center = true;
            }
            else if (vuMark.equals(RelicRecoveryVuMark.LEFT) ) {
                right = false;
                left = true;
                center = false;
            }
            else {
                right = false;
                left = false;
                center = true;
            }


        }

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
        finger.setPosition(.4);
        arm.setPosition(.6);

        //drive off stone
        time.reset();
        while (opModeIsActive() && time.seconds() <.75 && center){
            FRM.setPower(1);
            FLM.setPower(1);
            BRM.setPower(-1);
            BLM.setPower(-1);
        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.4 && left){
            FRM.setPower(1);
            FLM.setPower(1);
            BRM.setPower(-1);
            BLM.setPower(-1);
        }
        time.reset();
        while (opModeIsActive() && time.seconds() <1 && right){
            FRM.setPower(1);
            FLM.setPower(1);
            BRM.setPower(-1);
            BLM.setPower(-1);
        }

        /*
        time.reset();
        while (opModeIsActive() && time.seconds() <0){
            FRM.setPower(.5);
            FLM.setPower(.5);
            BRM.setPower(-.5);
            BLM.setPower(-.5);
        }

        time.reset();

        while (opModeIsActive() && time.seconds() <0){
            FRM.setPower(.5);
            FLM.setPower(.5);
            BRM.setPower(-.5);
            BLM.setPower(-.5);
        }*/
        FRM.setPower(0);
        FLM.setPower(0);
        BRM.setPower(0);
        BLM.setPower(0);
        //place first block
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
        //go get more
        time.reset();
        while (opModeIsActive() && time.seconds() <3){
            FLM.setPower(-.5);
            FRM.setPower(.5);
            BLM.setPower(-.5);
            BRM.setPower(.5);
            lift.setPower(-1);
            thunker.setPower(.33);
            gate.setPosition(0);
            if (right){
                AmbLight = Rcolor.blue()-Rcolor.red();
            }
            if (left){
                AmbLight = Lcolor.blue()-Lcolor.red();
            }
            if (center && time.seconds() >2){
                AmbLight = Lcolor.blue()-Lcolor.red();
            }
        }

        time.reset();
        while (opModeIsActive() && time.seconds() <1.5 && NoColor){
            telemetry.addData("BlueR ", Rcolor.blue());
            telemetry.addData("BlueL ", Lcolor.blue());
            telemetry.update();
            FLM.setPower(-.75);
            FRM.setPower(.75);
            BLM.setPower(-.75);
            BRM.setPower(.75);
            lift.setPower(-1);

            if (Lcolor.blue()-Lcolor.red() > AmbLight+5 || Rcolor.blue()-Rcolor.red() > AmbLight+5 && time.seconds()> .5){

                NoColor = false;
            }
        }
        FLM.setPower(0);
        FRM.setPower(0);
        BLM.setPower(0);
        BRM.setPower(0);
        lift.setPower(0);
        NoColor = true;
        NoBlock = true;
        //collect
        time.reset();
        while (opModeIsActive() && NoBlock){



            if (opModeIsActive() && time.seconds() <.9){
                FLM.setPower(-1);
                FRM.setPower(-1);
                BLM.setPower(-1);
                BRM.setPower(-1);
                lift.setPower(1);
            }


            else if (opModeIsActive() && time.seconds() <2.3 && time.seconds() >.9){
                FLM.setPower(.31);
                FRM.setPower(.31);
                BLM.setPower(.31);
                BRM.setPower(.31);
                flapper.setPower(-1);
                lift.setPower(0);
            }
            else if (opModeIsActive() && time.seconds() >2.3 && time.seconds() < 3.1){
                FLM.setPower(-1);
                FRM.setPower(1);
                BLM.setPower(-1);
                BRM.setPower(1);
                flapper.setPower(-1);
            }
            else if   (opModeIsActive() && time.seconds() <3.6 && time.seconds() > 3.1){
                FLM.setPower(1);
                FRM.setPower(-1);
                BLM.setPower(1);
                BRM.setPower(-1);
                flapper.setPower(-1);
            }
            else if (opModeIsActive() && time.seconds() >3.6 && time.seconds() < 4.4){
                FLM.setPower(-1);
                FRM.setPower(1);
                BLM.setPower(-1);
                BRM.setPower(1);
                flapper.setPower(-1);

            }
            else{
                FLM.setPower(0);
                FRM.setPower(0);
                BLM.setPower(0);
                BRM.setPower(0);
                lift.setPower(0);
                NoBlock = false;
            }
        }
        //straighten
        while (opModeIsActive() && NotSq){
            if(Lcolor.blue() >.2 && Rcolor.blue()>.2){
                NotSq = false;
            }
            else if (Lcolor.blue()> .2){
                FLM.setPower(.2);
                FRM.setPower(-1);
                BLM.setPower(.2);
                BRM.setPower(-1);
            }
            else if (Rcolor.blue()>.2){
                FLM.setPower(1);
                FRM.setPower(.2);
                BLM.setPower(1);
                BRM.setPower(.2);
            }
            else{
                FLM.setPower(1);
                FRM.setPower(-1);
                BLM.setPower(1);
                BRM.setPower(-1);
            }
        }
        NotSq = true;
        //go back
        time.reset();
        while (opModeIsActive() && time.seconds() <1.2){
            FLM.setPower(1);
            FRM.setPower(-1);
            BLM.setPower(1);
            BRM.setPower(-1);
        }
        //straighten
        while (opModeIsActive() && NoColor){
            telemetry.addData("BlueR ", Rcolor.blue());
            telemetry.addData("BlueL ", Lcolor.blue());
            telemetry.update();
            FLM.setPower(.3);
            FRM.setPower(-.3);
            BLM.setPower(.3);
            BRM.setPower(-.3);
            if (Lcolor.blue()-Lcolor.red() > AmbLight+5){
                NoColor = false;
                lc = true;
                rc = false;
            }
            if (Rcolor.blue()-Rcolor.red() > AmbLight+5 ){
                NoColor = false;
                rc = true;
                lc = false;
            }
        }
        NoColor = true;
        //drive to straighten
        while (opModeIsActive() && rc){
            //do stuff.
            telemetry.addData("BlueR ", Rcolor.blue());
            telemetry.addData("BlueL ", Lcolor.blue());
            telemetry.update();
            if (Lcolor.blue() -Lcolor.red() > AmbLight+5){
                done = true;
            }
            if (opModeIsActive() && !done){
                FRM.setPower(-.3);
                FLM.setPower(-.3);
                BRM.setPower(.3);
                BLM.setPower(.3);
            }
            else if (opModeIsActive() && done && Rcolor.blue() < .2){
                FRM.setPower(.3);
                FLM.setPower(0);
                BRM.setPower(-.3);
                BLM.setPower(0);
            }
            else if (opModeIsActive() && done && Rcolor.blue() > .2){
                FRM.setPower(0);
                FLM.setPower(0);
                BRM.setPower(0);
                BLM.setPower(0);
                rc = false;
            }



        }
        while (opModeIsActive() && lc){
            //do stuff.
            if (Rcolor.blue() -Lcolor.red() > AmbLight+5){
                done = true;
            }
            if (opModeIsActive() && !done){
                FRM.setPower(.3);
                FLM.setPower(.3);
                BRM.setPower(-.3);
                BLM.setPower(-.3);
            }
            else if (opModeIsActive() && done && Lcolor.blue() < .2){
                FRM.setPower(0);
                FLM.setPower(-.3);
                BRM.setPower(0);
                BLM.setPower(.3);
            }
            else if (opModeIsActive() && done && Lcolor.blue() > .2){
                FRM.setPower(0);
                FLM.setPower(0);
                BRM.setPower(0);
                BLM.setPower(0);
                lc = false;
            }
        }
        //place second and third blocks
        time.reset();
        while (opModeIsActive() && time.seconds() <.3 && center){
            FRM.setPower(.3);
            FLM.setPower(.3);
            BRM.setPower(-.3);
            BLM.setPower(-.3);
            right = true;
        }
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
            center=true;
        }

        time.reset();
        while (opModeIsActive() && time.seconds() <3){
            FLM.setPower(-.5);
            FRM.setPower(.5);
            BLM.setPower(-.5);
            BRM.setPower(.5);
            lift.setPower(-1);
            thunker.setPower(.33);
            gate.setPosition(0);
            if (right){
                AmbLight = Rcolor.blue();
            }
            if (left){
                AmbLight = Lcolor.blue();
            }
            if (center && time.seconds() >2){
                AmbLight = Lcolor.blue();
            }
        }
        //go get 4 & 5
        time.reset();
        while (opModeIsActive() && time.seconds() <3 && NoColor){
            FLM.setPower(-.75);
            FRM.setPower(.75);
            BLM.setPower(-.75);
            BRM.setPower(.75);


            if (Lcolor.blue()-Lcolor.red() > AmbLight || Rcolor.blue() > AmbLight+25 && time.seconds()> .5){

                NoColor = false;
            }
        }
        //collect again
        time.reset();
        while (opModeIsActive() && NoBlock){

            if(Block.blue()>.2 || Block.red() >.2){
                atime.reset();
                if(Block.blue()>.2 && atime.seconds() > .5 || Block.red() >.2 && atime.seconds() > .5){
                    NoBlock = false;
                }
            }

            while (opModeIsActive() && time.seconds() <1){
                FLM.setPower(-1);
                FRM.setPower(-1);
                BLM.setPower(1);
                BRM.setPower(1);

            }
            lift.setPower(0);
            thunker.setPower(.0);
            FRM.setPower(0);
            FLM.setPower(0);
            BRM.setPower(0);
            BLM.setPower(0);
            sleep(333);

            while (opModeIsActive() && time.seconds() <2.3 && time.seconds() >1){
                FLM.setPower(.31);
                FRM.setPower(.31);
                BLM.setPower(-.31);
                BRM.setPower(-.31);
                flapper.setPower(-1);
            }
            while (opModeIsActive() && time.seconds() >2.3 && time.seconds() < 3.1){
                FLM.setPower(-1);
                FRM.setPower(1);
                BLM.setPower(-1);
                BRM.setPower(1);
                flapper.setPower(-1);
            }
            while (opModeIsActive() && time.seconds() <3.6 && time.seconds() > 3.1){
                FLM.setPower(1);
                FRM.setPower(-1);
                BLM.setPower(1);
                BRM.setPower(-1);
                flapper.setPower(-1);
            }
            while (opModeIsActive() && time.seconds() >3.6 && time.seconds() < 4.4){
                FLM.setPower(-1);
                FRM.setPower(1);
                BLM.setPower(-1);
                BRM.setPower(1);
                flapper.setPower(-1);
                NoBlock = false;
            }
        }
        //straighten again
        while (opModeIsActive() && NotSq) {
            if (Lcolor.blue() > .2 && Rcolor.blue() > .2) {
                NotSq = false;
            } else if (Lcolor.blue() > .2) {
                FLM.setPower(.2);
                FRM.setPower(-1);
                BLM.setPower(.2);
                BRM.setPower(-1);
            } else if (Rcolor.blue() > .2) {
                FLM.setPower(1);
                FRM.setPower(.2);
                BLM.setPower(1);
                BRM.setPower(.2);
            } else {
                FLM.setPower(1);
                FRM.setPower(-1);
                BLM.setPower(1);
                BRM.setPower(-1);
            }
        }
        NotSq = true;
        //go back again
        time.reset();
        while (opModeIsActive() && time.seconds() <1.2){
            FLM.setPower(1);
            FRM.setPower(-1);
            BLM.setPower(1);
            BRM.setPower(-1);
        }
        while (opModeIsActive() && NoColor){
            FLM.setPower(.3);
            FRM.setPower(-.3);
            BLM.setPower(.3);
            BRM.setPower(-.3);
            if (Lcolor.blue() > .2){
                NoColor = false;
                lc = true;
                rc = false;
            }
            if (Rcolor.blue() >.2 ){
                NoColor = false;
                rc = true;
                lc = false;
            }
        }
        //straighten again
        NoColor = true;
        while (opModeIsActive() && rc){
            //do stuff.
            if (Lcolor.blue() > .2){
                done = true;
            }
            if (opModeIsActive() && !done){
                FRM.setPower(-.3);
                FLM.setPower(-.3);
                BRM.setPower(.3);
                BLM.setPower(.3);
            }
            else if (opModeIsActive() && done && Rcolor.blue() < .2){
                FRM.setPower(.3);
                FLM.setPower(0);
                BRM.setPower(-.3);
                BLM.setPower(0);
            }
            else if (opModeIsActive() && done && Rcolor.blue() > .2){
                FRM.setPower(0);
                FLM.setPower(0);
                BRM.setPower(0);
                BLM.setPower(0);
                rc = false;
            }



        }
        while (opModeIsActive() && lc){
            //do stuff.
            if (Rcolor.blue() > .2){
                done = true;
            }
            if (opModeIsActive() && !done){
                FRM.setPower(.3);
                FLM.setPower(.3);
                BRM.setPower(-.3);
                BLM.setPower(-.3);
            }
            else if (opModeIsActive() && done && Lcolor.blue() < .2){
                FRM.setPower(0);
                FLM.setPower(-.3);
                BRM.setPower(0);
                BLM.setPower(.3);
            }
            else if (opModeIsActive() && done && Lcolor.blue() > .2){
                FRM.setPower(0);
                FLM.setPower(0);
                BRM.setPower(0);
                BLM.setPower(0);
                lc = false;
            }
        }
        //dump 4 &5
        time.reset();
        while (opModeIsActive() && time.seconds() <.3 && center){
            FRM.setPower(.3);
            FLM.setPower(.3);
            BRM.setPower(-.3);
            BLM.setPower(-.3);
        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.3 && center && right){
            FRM.setPower(-.3);
            FLM.setPower(-.3);
            BRM.setPower(.3);
            BLM.setPower(.3);
        }
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
        while (opModeIsActive() && time.seconds() <.2){
            FLM.setPower(-1);
            FRM.setPower(1);
            BLM.setPower(-1);
            BRM.setPower(1);

        }
        FLM.setPower(0);
        FRM.setPower(0);
        BLM.setPower(0);
        BRM.setPower(0);
        time.reset();
        while (opModeIsActive() && time.seconds() <1){

        }
        arm.setPosition(.5);
        time.reset();
        while (opModeIsActive() && time.seconds() <1){

        }

        /*
        time.reset();
        while (opModeIsActive() && time.seconds() <.6){
            FLM.setPower(-.5);
            FRM.setPower(.5);
            BLM.setPower(-.5);
            BRM.setPower(.5);
            lift.setPower(-1);


        }

        FRM.setPower(0);
        FLM.setPower(0);
        BRM.setPower(0);
        BLM.setPower(0);
        time.reset();
        while (opModeIsActive() && time.seconds() <.2){
            thunker.setPower(.33);
            gate.setPosition(0);
            lift.setPower(-1);
        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.7){
            FLM.setPower(-1);
            FRM.setPower(1);
            BLM.setPower(-1);
            BRM.setPower(1);
            lift.setPower(-1);



        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.5){
            FLM.setPower(-1);
            FRM.setPower(1);
            BLM.setPower(-1);
            BRM.setPower(1);
            lift.setPower(-1);
        }
        lift.setPower(0);
        time.reset();

        time.reset();
        while (opModeIsActive() && time.seconds() <.9){
            FLM.setPower(-1);
            FRM.setPower(-1);
            BLM.setPower(-1);
            BRM.setPower(-1);
            lift.setPower(1);
        }
        lift.setPower(0);
        thunker.setPower(.0);

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
        flapper.setPower(0);
        time.reset();
        while (opModeIsActive() && time.seconds() <1.2){
            FLM.setPower(1);
            FRM.setPower(-1);
            BLM.setPower(1);
            BRM.setPower(-1);

        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.3 && right){
            FRM.setPower(-1);
            FLM.setPower(-1);
            BRM.setPower(1);
            BLM.setPower(1);
        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.3 && left){
            FRM.setPower(1);
            FLM.setPower(1);
            BRM.setPower(-1);
            BLM.setPower(-1);
        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.6){
            FLM.setPower(1);
            FRM.setPower(-1);
            BLM.setPower(1);
            BRM.setPower(-1);

        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.2){
            FLM.setPower(-1);
            FRM.setPower(1);
            BLM.setPower(-1);
            BRM.setPower(1);

        }
        FLM.setPower(0);
        FRM.setPower(0);
        BLM.setPower(0);
        BRM.setPower(0);
        time.reset();
        while (opModeIsActive() && time.seconds() <1){

        }
        arm.setPosition(.5);
        time.reset();
        while (opModeIsActive() && time.seconds() <1){

        }*/
        /*
        time.reset();
        while (opModeIsActive() && time.seconds() <.3){
            FLM.setPower(-1);
            FRM.setPower(1);
            BLM.setPower(-1);
            BRM.setPower(1);

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
        while (opModeIsActive() && time.seconds() <1){
            FLM.setPower(1);
            FRM.setPower(-1);
            BLM.setPower(1);
            BRM.setPower(-1);
            thunker.setPower(0);

        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.3){
            FLM.setPower(-1);
            FRM.setPower(1);
            BLM.setPower(-1);
            BRM.setPower(1);
            if(ods.getLightDetected()>.6){
                ttime.reset();
                if(ods > .6 && ttime > .75){
                    block = true;
                }
            }

        }*/


    }

    String format(OpenGLMatrix transformationMatrix) {
        return (transformationMatrix != null) ? transformationMatrix.formatAsTransform() : "null";
    }
}
