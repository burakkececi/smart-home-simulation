package concrete;

import abstraction.ISensor;
import abstraction.ISignal;

public class TemperatureSensor implements ISensor<Integer> {

    int temperature;

    @Override
    public void setStatus(Integer temperature) {
        this.temperature = temperature;
    }

    @Override
    public ISignal<Integer> getStatus() {
        return new Signal<>(this.temperature);
    }

}
