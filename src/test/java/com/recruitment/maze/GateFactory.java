package com.recruitment.maze;

public class GateFactory {
    private String gateSymbol;

    public GateFactory(String gateSymbol) {
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
