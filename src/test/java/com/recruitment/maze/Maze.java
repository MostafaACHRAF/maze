package com.recruitment.maze;

class Maze {
    private Path path = new Path();

    Maze(String... roomToRoomRelations) {
        for (String roomToRoomRelation : roomToRoomRelations)
            RoomsWired.wireFrom(roomToRoomRelation);
    }

    void popIn(String roomCode) {
        Room room = RoomFactory.getRoomByCode(roomCode);
        path.init(room);
    }

    Maze walkTo(String roomCode) {
        Room targetedRoom = RoomFactory.getRoomByCode(roomCode);
        System.out.println(targetedRoom);
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
