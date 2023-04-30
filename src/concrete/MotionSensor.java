package concrete;

import abstraction.IRandomize;
import abstraction.ISensor;
import abstraction.ISignal;

public class MotionSensor implements ISensor<Boolean> , IRandomize {

    boolean motionDetected;

    @Override
    public void setStatus(Boolean status) {
        this.motionDetected = status;
    }

    @Override
    public ISignal<Boolean> getStatus() {
        return new Signal<>(motionDetected);
    }

}
