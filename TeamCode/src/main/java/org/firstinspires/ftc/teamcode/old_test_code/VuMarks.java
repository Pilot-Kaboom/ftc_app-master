package org.firstinspires.ftc.teamcode.old_test_code;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;

import static org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark.UNKNOWN;

/**
 * Created by recharged on 12/9/17.
 */

public class VuMarks {

    final String LICENSE_KEY;
    LinearOpMode linearOpMode;
    MasterVuforia masterVuforia;

    public void close(){
    }

    public VuMarks(LinearOpMode linearOpMode, String LICENSE_KEY, MasterVuforia masterVuforia) {
        this.linearOpMode = linearOpMode;
        this.LICENSE_KEY = LICENSE_KEY;
        this.masterVuforia = masterVuforia;
    }

    public void init(VuforiaLocalizer.CameraDirection cameraDirection){
    }

    public RelicRecoveryVuMark getVuMark(int readings) {
        //return RelicRecoveryVuMark.from(relicTemplate);
        RelicRecoveryVuMark vuMark = UNKNOWN;
        if(readings <= 0)
            readings = 1;
        for (int i = 0; i < readings; i++) {
            vuMark = RelicRecoveryVuMark.from(masterVuforia.relicTemplate);
            if (vuMark != UNKNOWN)
                break;
            if (!linearOpMode.opModeIsActive())
                break;
            linearOpMode.sleep(100);
        }
        return vuMark;
    }

    public void activate(){
        masterVuforia.relicTrackables.activate();
    }

    public void deactivate(){
        masterVuforia.relicTrackables.deactivate();
    }

    @Deprecated
    public VuMarks(){
        this.LICENSE_KEY = null;
    }
}
