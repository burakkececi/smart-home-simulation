package concrete;

import abstraction.IActuator;

public class DoorLock implements IActuator<Boolean> {

    boolean isLocked;

    @Override
    public void toggle() {
        isLocked = !isLocked;
    }

    @Override
    public Boolean getStatus() {
        return isLocked;
    }

}
