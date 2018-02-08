package com.recruitment.maze;

public class RoomFactory {
    private String code;

    public RoomFactory(String code) {
        this.code = code;
    }

    public Room create() {
        return new Room(code);
    }
}
