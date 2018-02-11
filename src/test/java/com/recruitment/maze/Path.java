package com.recruitment.maze;

import com.recruitment.maze.AppExceptions.ClosedDoorException;
import com.recruitment.maze.AppExceptions.IllegalMoveException;

import java.util.ArrayList;
import java.util.List;

import static com.recruitment.maze.AppConfiguration.PathConfig.*;

class Path {
    private List<Door> doors = new ArrayList<>();
    private Room previousRoom;
    private Room actualRoom;

    void init(Room room) {
        this.actualRoom = room;
    }

    Door getLastDoor() {
        int lastDoorIndex = this.doors.size() - 1;
        return this.doors.get(lastDoorIndex);
    }

    void walkTo(Room targetedRoom) {
        permutePreviousAndActualRooms(targetedRoom);
        Door commonDoor = createCommonDoor();
        if (commonDoor.isClosed())
            throw new ClosedDoorException();
        this.doors.add(commonDoor);
    }

    private void permutePreviousAndActualRooms(Room targetedRoom) {
        if (!targetedRoom.isNeibordOf(actualRoom))
            throw new IllegalMoveException();
        this.previousRoom = actualRoom;
        this.actualRoom = targetedRoom;
    }

    private Door createCommonDoor() {
        Gate previousGate = this.actualRoom.getGateTo(previousRoom);
        Gate actualGate = this.previousRoom.getGateTo(actualRoom);
        return new Door(previousGate, actualGate);
    }

    String displaySensorDoors() {
        List<Door> sensorDoors = getSensorsDoors();
        StringBuilder builder = new StringBuilder();
        int index = 0;
        for (Door sensorDoor : sensorDoors) {
            builder.append(sensorDoor);
            if (index != sensorDoors.size() - 1)
                builder.append(DOORS_SEPARATOR);
            index++;
        }
        return String.valueOf(builder);
    }

    private List<Door> getSensorsDoors() {
        List<Door> sensorsDoors = new ArrayList<>();
        for (Door door : doors) {
            if (door.isSensor())
                sensorsDoors.add(door);
        }
        return sensorsDoors;
    }
}
