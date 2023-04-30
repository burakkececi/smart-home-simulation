package concrete;

import abstraction.IThermostat;

public class Thermostat implements IThermostat {

    private boolean isOpen;
    private ThermostatStatus status;

    public Thermostat() {
        this.isOpen = false;
        this.status = ThermostatStatus.CLOSE;
    }

    @Override
    public void toggle() {
        isOpen = !isOpen;
    }

    @Override
    public ThermostatStatus getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(ThermostatStatus status) {
        this.status = status;
    }

    @Override
    public void heatUp() {
        this.status = ThermostatStatus.HEATING;
    }

    @Override
    public void heatDown() {
        this.status = ThermostatStatus.COOLING;
    }

}
