package abstraction;

public interface ISensor<T>{

    void setStatus(T status);

    T getStatus();

}
