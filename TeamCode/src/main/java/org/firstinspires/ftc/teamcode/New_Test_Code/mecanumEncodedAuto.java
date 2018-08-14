package org.firstinspires.ftc.teamcode.New_Test_Code;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Keith Harder on 8/11/2018.
 */
@Autonomous(name="mecanumEncodedAuto", group="Auto1")
public class mecanumEncodedAuto extends mecanumBotHard {
    @Override
    public void run() {
        ResetEC();
        idle();
        RunInEC();
        idle();
        while(opModeIsActive() && FEC < 1000){
            goForward(.25);
            ticks();
            telem();
        }
        StopMotors(0);

        ResetEC();
        idle();
        RunInEC();
        idle();


        while(opModeIsActive() && REC < 1000){
            goRight(.25);
            ticks();
            telem();
        }
        StopMotors(0);
        ResetEC();
        idle();
        RunInEC();
        idle();
        while(opModeIsActive() && BEC < 1000){
            goForward(-.25);
            ticks();
            telem();
        }
        StopMotors(0);
        ResetEC();
        idle();
        RunInEC();
        idle();
        while(opModeIsActive() && LEC < 1000){
            goRight(-.25);
            ticks();
            telem();
        }
        StopMotors(0);
        ResetEC();
        idle();
        RunInEC();
        idle();
    }
}
