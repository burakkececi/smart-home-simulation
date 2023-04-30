package concrete;

import abstraction.IRandomize;
import abstraction.ISensor;
import abstraction.ISignal;

public class TemperatureSensor implements ISensor<Integer>, IRandomize {

    int temperature;

    @Override
    public void setStatus(Integer temperature) {
        this.temperature = temperature;
    }

    @Override
    public ISignal<Integer> getStatus() {
        setStatus(IRandomize.randomize(15, 30));
        return new Signal<>(this.temperature);
    }

    public String toString() {
        return "Temperature: " + temperature + "°C";
    }

}
