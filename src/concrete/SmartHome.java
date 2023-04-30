package concrete;

import abstraction.IActuator;
import abstraction.IControlPanel;
import abstraction.ISensor;
import abstraction.IThermostat;

public class SmartHome implements IControlPanel {

    ISensor<Boolean> lightSensor;
    IActuator<Boolean> lightBulb;
    ISensor<Boolean> motionSensor;
    IActuator<Boolean> doorLock;
    ISensor<Integer> temperatureSensor;
    IThermostat thermostat;

    public SmartHome(ISensor<Boolean> lightSensor, IActuator<Boolean> lightBulb,
                     ISensor<Boolean> motionSensor, IActuator<Boolean> doorLock,
                     ISensor<Integer> temperatureSensor, IThermostat thermostat) {
        this.lightSensor = lightSensor;
        this.lightBulb = lightBulb;
        this.motionSensor = motionSensor;
        this.doorLock = doorLock;
        this.temperatureSensor = temperatureSensor;
        this.thermostat = thermostat;
    }

    @Override
    public void display() {
        System.out.println("==============================================");
        System.out.println("Information from sensors:");
        System.out.println(lightSensor.toString());
        System.out.println(motionSensor.toString());
        System.out.println(temperatureSensor.toString());
        System.out.println("\nInformation from actuators:");
        System.out.println(lightBulb.toString());
        System.out.println(doorLock.toString());
        System.out.println(thermostat.toString());
        System.out.println("==============================================");
    }

    @Override
    public void toggleLight() {
        lightBulb.toggle();
        lightSensor.setStatus(lightBulb.getStatus());
    }

    @Override
    public void toggleDoor() {
        doorLock.toggle();
        motionSensor.setStatus(doorLock.getStatus());
    }

    @Override
    public void optimizeHeat() {
        int temperature = temperatureSensor.getStatus();

        if (temperature < 20) {
            thermostat.toggle();
            thermostat.heatUp();
            thermostat.toggle();
        } else if (temperature > 25) {
            thermostat.toggle();
            thermostat.heatDown();
            thermostat.toggle();
        } else {
            thermostat.setStatus(ThermostatStatus.CLOSE);
        }
    }

}
