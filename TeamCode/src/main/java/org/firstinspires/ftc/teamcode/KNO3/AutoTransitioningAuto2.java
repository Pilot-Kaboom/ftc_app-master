package org.firstinspires.ftc.teamcode.KNO3;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.old_test_code.AutoTransitioner;


public class AutoTransitioningAuto2 extends OpMode {
    @Override
    public void init() {
        telemetry.addData("Initializing Here", true);

        AutoTransitioner.transitionOnStop(this, "TestTeleOp");
        // AutoTransitioner used in init()
    }

    @Override
    public void loop() {
        telemetry.addData("Timer", getRuntime());
    }
}
