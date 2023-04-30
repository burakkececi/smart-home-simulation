package concrete;

import abstraction.ISignal;

public class Signal<T> implements ISignal<T> {

    T data;

    public Signal(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}
