package concrete;

import abstraction.IActuator;

public class LightBulb implements IActuator<Boolean> {

    boolean isOn;

    public void toggle() {
        isOn = !isOn;
    }

    public Boolean getStatus() {
        return isOn;
    }

    public String toString() {
        return "Light is: " + (isOn ? "On" : "Off");
    }

}
