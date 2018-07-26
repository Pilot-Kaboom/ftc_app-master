package org.firstinspires.ftc.teamcode.New_Test_Code;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Keith Harder on 7/23/2018.
 */

public abstract class superSuperClass extends LinearOpMode {
    @Override
    public void runOpMode() {
        initiate();
        waitForStart();
        run();
    }
    public abstract void initiate();

    public abstract void run();
}
