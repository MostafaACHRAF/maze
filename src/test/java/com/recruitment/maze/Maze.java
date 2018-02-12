package com.recruitment.maze;

class Maze {
    private RoomsWired roomsWired = new RoomsWired();
    private Path path = new Path();

    Maze(String... roomToRoomRelations) {
        for (String roomToRoomRelation : roomToRoomRelations)
            roomsWired.wireFrom(roomToRoomRelation);
    }

    void popIn(String roomCode) {
        Room room = roomsWired.getRoomByCode(roomCode);
        path.init(room);
    }

    Maze walkTo(String roomCode) {
        Room targetedRoom = roomsWired.getRoomByCode(roomCode);
        System.out.println(roomsWired.displayCreatedRooms());
        path.walkTo(targetedRoom);
        return this;
    }

    void closeLastDoor() {
        path.getLastDoor().close();
    }

    String readSensors() {
        return path.displaySensorDoors();
    }
}
