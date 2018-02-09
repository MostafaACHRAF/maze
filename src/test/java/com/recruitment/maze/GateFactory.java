package com.recruitment.maze;

public class GateFactory {
    private String gateSymbol;

    GateFactory(String gateSymbol) {
        this.gateSymbol = gateSymbol;
    }

    public Gate create() {
        if (gateSymbol.equals("|")) {
            return new NormalGate();
        } else {
            return new SensorGate();
        }
    }
}
