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
            if(time.seconds()<2){
                RunInpower();
                idle();
            }

            if(gamepad1.dpad_right){
                goForward(1);
            }
            else if(gamepad1.dpad_left){
                goForward(-1);
            }
            else if (gamepad1.dpad_up){
                goRight(-1);
            }
            else if (gamepad1.dpad_down){
                goRight(1);
            }
            else if(gamepad1.left_trigger>.1){
                turn(1);
            }
            else if(gamepad1.right_trigger>.1){
                turn(-1);
            }
            else{
                StopMotors(0);
            }


            lights.setPosition(light);
            light = pos;

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
