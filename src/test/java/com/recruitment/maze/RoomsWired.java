package com.recruitment.maze;

import java.util.ArrayList;
import java.util.List;

import static com.recruitment.maze.AppConfiguration.RoomsWiredConfig.*;

class RoomsWired {
    private static String firstRoomCode;
    private static String secondRoomCode;
    private static String commonGateSymbol;

    static void wireFrom(String roomToRoomRelation) {
        extractedDataFrom(roomToRoomRelation);
        wire();
    }

    private static void extractedDataFrom(String roomToRoomRelation) {
        String[] extractedData = roomToRoomRelation.split(SPLIT_DATA_REGEX);
        firstRoomCode = extractedData[FIRST_ROOM_INDEX];
        commonGateSymbol = extractedData[GATE_ROOM_INDEX];
        secondRoomCode = extractedData[SECOND_ROOM_INDEX];
    }

    private static void wire() {
        Gate firstRoomGate = GateFactory.create(commonGateSymbol, secondRoomCode);
        Gate secondRoomGate = GateFactory.create(commonGateSymbol, firstRoomCode);
        RoomFactory.create(firstRoomCode, firstRoomGate);
        RoomFactory.create(secondRoomCode, secondRoomGate);
    }
}
