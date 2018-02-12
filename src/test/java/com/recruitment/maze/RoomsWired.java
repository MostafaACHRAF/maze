package com.recruitment.maze;

import static com.recruitment.maze.AppConfiguration.RoomsWiredConfig.*;

class RoomsWired {
    private static String firstRoomCode;
    private static String secondRoomCode;
    private static String commonGateSymbol;
    private GateFactory gateFactory = new GateFactory();
    private RoomFactory roomFactory = new RoomFactory();

    void wireFrom(String roomToRoomRelation) {
        extractedDataFrom(roomToRoomRelation);
        wire();
    }

    private static void extractedDataFrom(String roomToRoomRelation) {
        String[] extractedData = roomToRoomRelation.split(SPLIT_DATA_REGEX);
        firstRoomCode = extractedData[FIRST_ROOM_INDEX];
        commonGateSymbol = extractedData[GATE_ROOM_INDEX];
        secondRoomCode = extractedData[SECOND_ROOM_INDEX];
    }

    private void wire() {
        Gate firstRoomGate = gateFactory.create(commonGateSymbol, secondRoomCode);
        Gate secondRoomGate = gateFactory.create(commonGateSymbol, firstRoomCode);
        roomFactory.create(firstRoomCode, firstRoomGate);
        roomFactory.create(secondRoomCode, secondRoomGate);
    }

    Room getRoomByCode(String roomCode) {
        return roomFactory.getRoomByCode(roomCode);
    }

    String displayCreatedRooms() {
        return roomFactory.displayCreatedRooms();
    }
}
