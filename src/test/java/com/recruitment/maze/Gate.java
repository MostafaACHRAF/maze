package com.recruitment.maze;

public abstract class Gate implements Cloneable {
    private Room room;
    private String state;

    public Gate() {
        this.state = "OPENED";
    }

    public Room getRoom() {
        return room;
    }

    public void gateTo(Room room) {
        this.room = room;
    }

    public void close() {
        this.state = "CLOSED";
    }

    @Override
    protected Gate clone() throws CloneNotSupportedException {
        return (Gate) super.clone();
    }
}
