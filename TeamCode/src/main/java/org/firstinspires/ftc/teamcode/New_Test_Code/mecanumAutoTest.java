package org.firstinspires.ftc.teamcode.New_Test_Code;

/**
 * Created by Keith Harder on 7/27/2018.
 */

public class mecanumAutoTest extends mecanumBotHard {


    @Override
    public void run() {
        while(opModeIsActive()){
            while(time.seconds()<3){
                goForward(1);
            }
            while(time.seconds()<2){
                goLeft(1);
            }
            while(time.seconds()<3){
                goBackward(1);
            }
            while(time.seconds()<2){
                goRight(1);
            }
        }
    }
}