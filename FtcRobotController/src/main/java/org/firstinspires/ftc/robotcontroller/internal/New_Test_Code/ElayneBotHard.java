package org.firstinspires.ftc.robotcontroller.internal.New_Test_Code;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Keith Harder on 7/23/2018.
 */

public abstract class ElayneBotHard extends superSuperClass {

    private DcMotor left;
    private DcMotor right;

    public ElapsedTime time;


    @Override
    public void initiate() {

        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");

        left.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void powerLeft(double power){
        left.setPower(power);
    }
    public void powerRight(double power){
        right.setPower(power);
    }
}
