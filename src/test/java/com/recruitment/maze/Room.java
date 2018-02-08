package com.recruitment.maze;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String code;
    private List<Gate> gates;

    public Room(String code) {
        this.code = code;
        this.gates = new ArrayList<Gate>();
    }

    public void addNewGate(Gate gate) {
        this.gates.add(gate);
    }
}
