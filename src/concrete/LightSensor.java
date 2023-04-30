package concrete;

import abstraction.ISensor;

public class LightSensor implements ISensor<Boolean> {

    boolean isOn;

    @Override
    public void setStatus(Boolean status) {
        this.isOn = status;
    }

    @Override
    public Boolean getStatus() {
        return this.isOn;
    }

    public String toString() {
        return "Light is: " + (isOn ? "On" : "Off");
    }

}
