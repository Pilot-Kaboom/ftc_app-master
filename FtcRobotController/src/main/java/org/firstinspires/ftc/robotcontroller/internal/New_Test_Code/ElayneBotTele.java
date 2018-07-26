package org.firstinspires.ftc.robotcontroller.internal.New_Test_Code;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Keith Harder on 7/23/2018.
 */
@TeleOp(name="ElayneTele", group="Tele1")
public class ElayneBotTele extends ElayneBotHard {

    @Override
    public void run() {

        while(opModeIsActive()){
            powerLeft(gamepad1.left_stick_y);
            powerRight(gamepad1.right_stick_y);
        }
    }

}
