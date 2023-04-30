package concrete;

import abstraction.IRandomize;
import abstraction.ISensor;

public class TemperatureSensor implements ISensor<Integer>, IRandomize {

    int temperature;

    @Override
    public void setStatus(Integer temperature) {
        this.temperature = temperature;
    }

    @Override
    public Integer getStatus() {
        setStatus(IRandomize.randomize(15, 30));
        return this.temperature;
    }

    public String toString() {
        return "Temperature: " + temperature + "°C";
    }

}
