package com.recruitment.maze;

import java.util.ArrayList;
import java.util.List;

class Room {
    String code;
    private List<Gate> gates = new ArrayList<>();

    Room(String code, Gate gate) {
        this.code = code;
        this.gates.add(gate);
    }

    void addNewGate(Gate gate) {
        this.gates.add(gate);
    }

    @Override
    public String toString() {
        return code;
    }

    boolean isNeibordOf(Room room) {
        for (Gate gate : gates) {
            if (gate.isGateTo(room.code))
                return true;
        }
        return false;
    }

    Gate getGateTo(Room room) {
        for (Gate gate : gates) {
            if (gate.isGateTo(room.code))
                return gate;
        }
        return null;
    }

    Gate get(Gate gate) {
        return gates.get(gates.indexOf(gate));
    }

    void displayGates() {
        for (Gate gate : gates) {
            System.out.println(gate);
        }
    }
}
