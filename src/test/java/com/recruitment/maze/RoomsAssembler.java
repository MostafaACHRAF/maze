package com.recruitment.maze;

import java.util.ArrayList;
import java.util.List;

public class RoomsAssembler {

    public static List<Room> from(String[] roomsRelations) {
        List<Room> rooms = new ArrayList<>();


        String firstRoomCode = splitedData[0];
        String gateSymbol = splitedData[1];
        String secondRoomCode = splitedData[2];

        Room firstRoom = RoomFactory.get(firstRoomCode);
        Room secondRoom = RoomFactory.get(secondRoomCode);
        Gate commonGate = GateFactory.get(gateSymbol);

        try {
            Gate firstRoomGate = commonGate.clone();
            Gate secondRoomGate = commonGate.clone();

            firstRoomGate.gateTo(secondRoom);
            secondRoomGate.gateTo(firstRoom);

            firstRoom.addNewGate(firstRoomGate);
            secondRoom.addNewGate(secondRoomGate);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        this.rooms.add(firstRoom);
        this.rooms.add(secondRoom);
    }


}
