package com.recruitment.maze;

import com.recruitment.maze.AppExceptions.DoorAlreadyClosedException;

import static com.recruitment.maze.AppConfiguration.DoorConfig.*;

public class Door {
    private Gate firstGate;
    private Gate secondGate;
    private String type;

    Door(Gate firstGate, Gate secondGate) {
        this.firstGate = firstGate;
        this.secondGate = secondGate;
        setType();
    }

    boolean isSensor() {
        return this.type.equals(SENSOR_GATE);
    }

    boolean isClosed() {
        return firstGate.isClosed() && secondGate.isClosed();
    }

    void close() {
        if (isClosed())
            throw new DoorAlreadyClosedException();
        firstGate.close();
        secondGate.close();
    }

    private void setType() {
        if (firstGate instanceof NormalGate)
            this.type = NORMAL_GATE;
        else
            this.type = SENSOR_GATE;
    }

    @Override
    public String toString() {
        return firstGate + "" + secondGate;
    }
}
