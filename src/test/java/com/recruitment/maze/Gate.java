package com.recruitment.maze;

import static com.recruitment.maze.AppConfiguration.GateFactoryConfig.CLOSED;
import static com.recruitment.maze.AppConfiguration.GateFactoryConfig.OPENED;

abstract class Gate {
    private String toRoomCode;
    private String state;

    Gate(String toRoomCode) {
        this.toRoomCode = toRoomCode;
        this.state = OPENED;
    }

    void close() {
        this.state = CLOSED;
    }

    boolean isGateTo(String roomCode) {
        return roomCode.equals(toRoomCode);
    }

    boolean isClosed() {
        return this.state.equals(CLOSED);
    }

    @Override
    public String toString() {
        return toRoomCode;
    }
}
