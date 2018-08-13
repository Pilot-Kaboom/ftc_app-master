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
        while(opModeIsActive() && FEC < 500){
            goForward(.25);
            ticks();
            telem();
        }
        ResetEC();

        while(opModeIsActive() && REC < 500){
            goRight(.25);
            ticks();
            telem();
        }
        ResetEC();

        while(opModeIsActive() && BEC < 500){
            goForward(-.25);
            ticks();
            telem();
        }
        ResetEC();

        while(opModeIsActive() && LEC < 500){
            goRight(-.25);
            ticks();
            telem();
        }
        ResetEC();

    }
}
