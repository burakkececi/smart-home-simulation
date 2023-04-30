package concrete;

import abstraction.IRandomize;
import abstraction.ISensor;

public class MotionSensor implements ISensor<Boolean> , IRandomize {

    boolean motionDetected;

    @Override
    public void setStatus(Boolean status) {
        this.motionDetected = status;
    }

    @Override
    public Boolean getStatus() {
        return this.motionDetected;
    }

    public String toString() {
        return "Motion detected: " + (motionDetected ? "Yes" : "No");
    }

}
