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
            telem();
            goForward(gamepad1.left_stick_y);
            goRight(gamepad1.left_stick_x);
            turn(gamepad1.right_trigger-gamepad1.left_trigger);

            lights.setPosition(light);
            light = gamepad1.right_trigger - gamepad1.left_trigger + pos;

            if (gamepad1.right_bumper && atime.seconds() > .5){
                pos = pos+.01;
                atime.reset();

            }
            else if (gamepad1.left_bumper && atime.seconds() > .5){
                pos = pos-.01;
                atime.reset();

            }
        }


    }
}
