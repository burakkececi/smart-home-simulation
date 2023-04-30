package abstraction;

public interface IActuator<T> {

    void toggle();

    T getStatus();

}
