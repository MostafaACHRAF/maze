package com.recruitment.maze;

import com.recruitment.maze.AppExceptions.IllegalMoveException;

import java.util.ArrayList;
import java.util.List;

class RoomFactory {
    private List<Room> createdRooms = new ArrayList<>();

    Room create(String roomCode, Gate gate) {
        if (isExist(roomCode)) {
            Room room = getRoomByCode(roomCode);
            assert room != null;
            room.addNewGate(gate);
            return room;
        }
        Room room = new Room(roomCode, gate);
        createdRooms.add(room);
        return room;
    }

    private boolean isExist(String roomCode) {
        for (Room room : createdRooms) {
            if (room.code.equals(roomCode))
                return true;
        }
        return false;
    }

    Room getRoomByCode(String code) {
        for (Room room : createdRooms) {
            if (room.code.equals(code))
                return room;
        }
        throw new IllegalMoveException();
    }

    String displayCreatedRooms() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Room room : createdRooms)
            stringBuilder.append(room.toString());
        return String.valueOf(stringBuilder);
    }
}
