package org.firstinspires.ftc.teamcode.old_test_code;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Keith Harder on 1/15/2018.
 */

public class Rev_color_sensor_test extends LinearOpMode {
    ColorSensor colorSensor;
    @Override
    public void runOpMode() throws InterruptedException{
        colorSensor = hardwareMap.get(ColorSensor.class, "color_sensor");
        colorSensor.enableLed(true);
        waitForStart();


        while (opModeIsActive()) {
            telemetry.addData("argb: ", colorSensor.argb());
            telemetry.addData("alpha: ", colorSensor.alpha());
            telemetry.addData("red: ", colorSensor.red());
            telemetry.addData("blue: ", colorSensor.blue());
            telemetry.addData("green: ", colorSensor.green());
            telemetry.addData("Ball: ", colorSensor.red() > colorSensor.blue() ? "red" : "blue");
            telemetry.update();
        }
    }
}
