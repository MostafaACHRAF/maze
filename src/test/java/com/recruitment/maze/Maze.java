package com.recruitment.maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private final List<Room> assembledRooms = new ArrayList<>();

    Maze(String... roomsRelations) {
        //List<Room> rooms = RoomsAssembler.from(roomsRelations);
        //this.assembledRooms.addAll(rooms);
    }

    public void popIn(String roomCode) {
    }

    public void walkTo(String roomCode) {
    }

    public void closeLastDoor() {
    }

    public String readSensors() {
        return "";
    }
}
