package com.recruitment.maze;

import java.util.Collection;

public class RoomsWired {
    private static String firstRoomCode;
    private static String secondRoomCode;
    private static String commonGateSymbol;

    public static Collection<? extends Room> wire(String roomToRoomRelation) {
        extractedData(roomToRoomRelation);

        Gate commonGate = RoomFactory.create(commonGateSymbol);
        Room firstRoom = RoomFactory.create(secondRoomCode, commonGate);
        Room secondRoom = RoomFactory.get(splitedRoomToRoomRelation[2]);
    }

    private static void extractedData(String roomToRoomRelation) {
        String[] splitedRoomToRoomRelation = roomToRoomRelation.split("");
        firstRoomCode = splitedRoomToRoomRelation[0];
        commonGateSymbol = splitedRoomToRoomRelation[1];
        secondRoomCode = splitedRoomToRoomRelation[2];
    }
}
