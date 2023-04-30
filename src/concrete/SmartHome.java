package concrete;

import abstraction.*;

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
        System.out.println("\nWelcome your home :)");
        System.out.printf("Your room is %d °C degree. Thermostat is %s\nYour light is %s.\nYour door is %s.\n",
                temperatureSensor.getStatus().getData(),
                thermostat.getStatus().toString(),
                lightSensor.getStatus().getData() ? "Open" : "Close",
                motionSensor.getStatus().getData() ? "Open" : "Close");
        //System.out.println("Door is open: " + doorLock.getStatus());
        //System.out.println("Temperature is: " + temperatureSensor.getStatus());
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
        int temperature = IRandomize.randomize(15, 30);
        temperatureSensor.setStatus(temperature);

        if (temperature < 20) {
            thermostat.toggle();
            thermostat.heatUp();
        } else if (temperature > 25) {
            thermostat.toggle();
            thermostat.heatDown();
        } else {
            thermostat.setStatus(ThermostatStatus.CLOSE);
        }
        thermostat.toggle();
    }

}
