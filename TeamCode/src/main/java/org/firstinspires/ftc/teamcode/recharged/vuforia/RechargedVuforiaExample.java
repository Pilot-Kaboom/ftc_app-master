package org.firstinspires.ftc.teamcode.recharged.vuforia;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.teamcode.old_test_code.MasterVuforia;

/**
 * Created by recharged on 12/13/17.
 */


public class RechargedVuforiaExample extends LinearOpMode{
    MasterVuforia vuforia;
    public void runOpMode() throws InterruptedException{

        vuforia = new MasterVuforia(this);
        vuforia.init(VuforiaLocalizer.CameraDirection.FRONT);// SELFIE-CAM!!!

        vuforia.activate();// do before wait for start otherwise it won't find the pictograph in time

        waitForStart();

        while(opModeIsActive()){
            telemetry.addData("VuMark: ", vuforia.vuMarks.getVuMark(5));
            telemetry.update();
        }

        vuforia.deactivate();
        vuforia.close();
    }
}
