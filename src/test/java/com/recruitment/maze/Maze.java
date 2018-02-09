package com.recruitment.maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private final List<Room> wiredRooms = new ArrayList<>();
    private List<Path> path;

    Maze(String... roomToRoomRelations) {
        for (String roomToRoomRelation : roomToRoomRelations) {
            wiredRooms.addAll(RoomsWired.wire(roomToRoomRelation));
            //this is the job of RoomToRoomWired
            /*RoomToRoom roomToRoom= RoomToRoomFactory.create(roomToRoomData);
            RoomToRoom configuredRoomToRoom = RoomToRoomConfigurer.configure(roomToRoom);
            configuredRooms.add(roomToRoom.getFirstRoom());
            configuredRooms.add(roomToRoom.getSecondRoom());*/
        }
    }

    public void popIn(String roomCode) {
        Room room = RoomFactory.get(roomCode);
        path.setActualRoom(room);
    }

    public Maze walkTo(String roomCode) {
        Room room = RoomFactory.get(roomCode);
        Room actualRoom = path.getActualRoom();
        if (room.isNeibordOf(actualRoom)) {
            path.setActualRoom(room);
        } else {
            throw new EllegalMoveException();
        }
        return this;
    }

    public void closeLastDoor() {
        path.getLastDoor().close();
    }

    public String readSensors() {
        List<Gate> sensorDoors = path.getSensorsDoors();
        return sensorDoors.toString();
    }
}
