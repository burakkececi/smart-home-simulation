package concrete;

import abstraction.ISensor;
import abstraction.ISignal;

public class LightSensor implements ISensor<Boolean> {

    boolean isOn;

    @Override
    public void setStatus(Boolean status) {
        this.isOn = status;
    }

    @Override
    public ISignal<Boolean> getStatus() {
        return new Signal<>(isOn);
    }

    public String toString() {
        return "Light is: " + (isOn ? "On" : "Off");
    }

}
