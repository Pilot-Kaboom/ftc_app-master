package org.firstinspires.ftc.teamcode.New_Test_Code;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Elayne Harder on 7/27/2018.
 */
@Autonomous(name="KeithsIdeaOfFun", group="Auto1")
public class KeithsIdeaOfFun extends ElayneBotHard{

    @Override
    public void run() {
        while (opModeIsActive()){
            while (time.seconds()<3){
                left.setPower(-3);
            }
            while (time.seconds()<3){
                right.setPower(3);
            }
            while (time.seconds()<3){
                left.setPower(-3);
                right.setPower(3);
            }
        }
    }
}
