package com.recruitment.maze;

import java.util.ArrayList;
import java.util.List;

public class RoomToRoomConfigurer {
    private List<Room> configuredRooms = new ArrayList<>();

    public RoomToRoomConfigurer(String firstRoomCode, String secondRoomCode, String commonGateSymbol) {
        Room firstRoom = RoomFactory.get(firstRoomCode);
        Room secondRoom = RoomFactory.get(secondRoomCode);
        Gate commonGate = GateFactory.get(commonGateSymbol);
        assemblyTwoRooms(firstRoom, secondRoom, commonGate);
    }

    private void assemblyTwoRooms(Room firstRoom, Room secondRoom, Gate commonGate) {
        commonGate.setFirstSide(firstRoom);
        commonGate.setSecondSide(secondRoom);
        firstRoom.addGateTo(secondRoom);
        secondRoom.addGateTo(firstRoom);
        configuredRooms.add(firstRoom);
        configuredRooms.add(secondRoom);
    }

    public List<Room> getConfiguredRooms() {
        return configuredRooms;
    }
}
