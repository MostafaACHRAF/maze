package com.recruitment.maze;

import java.util.Collection;
import java.util.List;

public class RoomsFactory {
    private List<Room> rooms;
    private String firstRoomCode;
    private String secondRoomCode;
    private String commonGateSymbol;

    public RoomsFactory(String data) {
        String[] fetchedData = data.split("");
        this.firstRoomCode = fetchedData[0];
        this.commonGateSymbol = fetchedData[1];
        this.secondRoomCode = fetchedData[2];
    }

    public List<Room> create() {
        Gate commonGate = new GateFactory(commonGateSymbol).create();
        Room firstRoom = new RoomFactory(firstRoomCode).create();
        Room secondRoom = new RoomFactory(secondRoomCode).create();

        try {
            Gate firstRoomGate = commonGate.clone();
            Gate secondRoomGate = commonGate.clone();

            firstRoomGate.setRoom(firstRoom);
            secondRoomGate.setRoom(secondRoom);

            firstRoom.addNewGate(secondRoomGate);
            secondRoom.addNewGate(firstRoomGate);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        firstRoom.addNewGate();
        return this.rooms;
    }
}
