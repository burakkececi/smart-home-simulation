import abstraction.*;
import concrete.*;

public class Main {
    public static void main(String[] args) {
        ISensor<Boolean> lightSensor = new LightSensor();
        ISensor<Boolean> motionSensor = new MotionSensor();
        ISensor<Integer> tempetureSensor = new TemperatureSensor();
        IActuator<Boolean> lightBulb = new LightBulb();
        IActuator<Boolean> doorLock = new DoorLock();
        IThermostat thermostat = new Thermostat();

        IControlPanel controlPanel = new SmartHome(lightSensor, lightBulb,
                                                    motionSensor, doorLock,
                                                    tempetureSensor, thermostat);

        controlPanel.display();
        int time = 0;
        while (time < 20) {
            // it will iterare every 1 seconds
            if (IRandomize.randomize(0, 1) == 1){
                controlPanel.toggleLight();
            }
            if (IRandomize.randomize(0, 1) == 1){
                controlPanel.toggleDoor();
            }
            controlPanel.optimizeHeat();

            controlPanel.display();
            time++;
            //Thread.sleep(1000);
        }
    }
}
