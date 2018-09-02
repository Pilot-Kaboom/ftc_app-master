package org.firstinspires.ftc.teamcode.New_Test_Code;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Keith Harder on 8/13/2018.
 */
@TeleOp(name="MecanumTele", group="Tele1")
public class MecanumTele extends mecanumBotHard {
    @Override
    public void run() {
        while (opModeIsActive()){
            goForward(gamepad1.left_stick_y);
            goRight(gamepad1.left_stick_x);

            lights.setPosition(light);
            light = gamepad1.right_trigger - gamepad1.left_trigger + pos;

            if (gamepad2.right_trigger > .5 && atime.seconds() > .5){
                pos = pos+.05;
                atime.reset();

            }
            else if (gamepad2.left_trigger > .5 && atime.seconds() > .5){
                pos = pos-.05;
                atime.reset();

            }
        }


    }
}
