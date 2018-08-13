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
        }
    }
}
