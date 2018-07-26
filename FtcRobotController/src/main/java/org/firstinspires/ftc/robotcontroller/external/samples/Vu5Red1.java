package org.firstinspires.ftc.robotcontroller.external.samples;



        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import java.util.prefs.Preferences;
        import com.qualcomm.robotcore.eventloop.opmode.Disabled;
        import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
        import com.qualcomm.robotcore.hardware.ColorSensor;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.Servo;
        import com.qualcomm.robotcore.util.ElapsedTime;

        import org.firstinspires.ftc.robotcore.external.ClassFactory;
        import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
        import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
        import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
        import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
        import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
        import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
        import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
        import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
        import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
        import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
        import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
        import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by Keith Harder on 1/16/2018.
 */
@Autonomous(name="Vu5Red1", group="Auto1")
public class Vu5Red1 extends LinearOpMode {


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

    private Boolean red;
    private Boolean blue;
    private Boolean left;
    private Boolean right;
    private Boolean center;

    private ElapsedTime time = new ElapsedTime();

    static final double     COUNTS_PER_MOTOR_REV    = 1120 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 2.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
                                                        (WHEEL_DIAMETER_INCHES * 3.14159);


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






        gate.setPosition(.8);
        time.reset();
        while (opModeIsActive() && time.seconds() <1){

        }
        arm.setPosition(.97);
        finger.setPosition(.25);
        time.reset();
        while (opModeIsActive() && time.seconds() <3) {
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
        sleep(3000);

        time.reset();
        while (opModeIsActive() && time.seconds() <1 && red){
            /*FRM.setPower(-.5);
            FLM.setPower(-.5);
            BRM.setPower(.5);
            BLM.setPower(.5);*/
            finger.setPosition(.0);

        }

        time.reset();
        while (opModeIsActive() && time.seconds() <1 && blue){
            /*FRM.setPower(1);
            FLM.setPower(1);
            BRM.setPower(-1);
            BLM.setPower(-1);*/
            finger.setPosition(0.6);

        }
        finger.setPosition(.4);
        arm.setPosition(.6);
        time.reset();
        while (opModeIsActive() && time.seconds() <.95 && center){
            FRM.setPower(-1);
            FLM.setPower(-1);
            BRM.setPower(1);
            BLM.setPower(1);
        }
        time.reset();
        while (opModeIsActive() && time.seconds() <1.15 && left){
            FRM.setPower(-1);
            FLM.setPower(-1);
            BRM.setPower(1);
            BLM.setPower(1);
        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.67 && right){
            FRM.setPower(-1);
            FLM.setPower(-1);
            BRM.setPower(1);
            BLM.setPower(1);
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
        time.reset();
        while (opModeIsActive() && time.seconds() <.5){
            FLM.setPower(-1);
            FRM.setPower(1);
            BLM.setPower(-1);
            BRM.setPower(1);
            lift.setPower(1);
        }
        time.reset();
        while (opModeIsActive() && time.seconds() <.3){
            FLM.setPower(1);
            FRM.setPower(-1);
            BLM.setPower(1);
            BRM.setPower(-1);
            lift.setPower(1);
        }
        lift.setPower(0);
        time.reset();

        time.reset();
        while (opModeIsActive() && time.seconds() <.9){
            FLM.setPower(-1);
            FRM.setPower(-1);
            BLM.setPower(0);
            BRM.setPower(0);
            lift.setPower(0);
        }
        lift.setPower(0);
        thunker.setPower(.0);

        time.reset();
        while (opModeIsActive() && time.seconds() <.75){
            FLM.setPower(1);
            FRM.setPower(1);
            BLM.setPower(0);
            BRM.setPower(0);

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
        while (opModeIsActive() && time.seconds() <.85){
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

        }
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

        }*/


    }
    String format(OpenGLMatrix transformationMatrix) {
        return (transformationMatrix != null) ? transformationMatrix.formatAsTransform() : "null";
    }
}
