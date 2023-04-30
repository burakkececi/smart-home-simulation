package abstraction;

import concrete.ThermostatStatus;

public interface IThermostat extends IActuator<ThermostatStatus> {

    void setStatus(ThermostatStatus close);

    void heatUp();

    void heatDown();

}
