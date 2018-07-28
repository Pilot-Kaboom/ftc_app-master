package org.firstinspires.ftc.teamcode.New_Test_Code;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Keith Harder on 7/27/2018.
 */

public abstract class mecanumBotHard extends superSuperClass {

    public DcMotor BRM;
    public DcMotor FLM;
    public DcMotor BLM;
    public DcMotor FRM;

    public ElapsedTime time;


    @Override
    public void initiate() {
        FLM = hardwareMap.dcMotor.get("flm");
        BLM = hardwareMap.dcMotor.get("blm");
        FRM = hardwareMap.dcMotor.get("frm");
        BRM = hardwareMap.dcMotor.get("brm");
    }

    //for traditional mecanum setup, use noted public voids.
    /*
    public void goForward(double power){
        FLM.setPower(-power);
        FRM.setPower(power);
        BLM.setPower(-power);
        BRM.setPower(power);
    }
    public void goBackward(double power){
        FLM.setPower(power);
        FRM.setPower(-power);
        BLM.setPower(power);
        BRM.setPower(-power);
    }
    public void goRight(double power){
        FLM.setPower(-power);
        FRM.setPower(-power);
        BLM.setPower(power);
        BRM.setPower(power);
    }
    public void goLeft(double power){
        FLM.setPower(power);
        FRM.setPower(power);
        BLM.setPower(-power);
        BRM.setPower(-power);
    }
     */
    public void goForward(double power){
        FLM.setPower(-power);
        FRM.setPower(power);
        BLM.setPower(-power);
        BRM.setPower(power);
    }
    public void goBackward(double power){
        FLM.setPower(power);
        FRM.setPower(-power);
        BLM.setPower(power);
        BRM.setPower(-power);
    }
    public void goRight(double power){
        FLM.setPower(-power);
        FRM.setPower(-power);
        BLM.setPower(power);
        BRM.setPower(power);
    }
    public void goLeft(double power){
        FLM.setPower(power);
        FRM.setPower(power);
        BLM.setPower(-power);
        BRM.setPower(-power);
    }
}
