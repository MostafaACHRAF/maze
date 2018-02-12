package com.recruitment.maze;

import static com.recruitment.maze.AppConfiguration.GateFactoryConfig.NORMAL_GATE_SYMBOL;

class GateFactory {

    Gate create(String gateSymbol, String toRoomCode) {
        if (gateSymbol.equals(NORMAL_GATE_SYMBOL)) {
            return new NormalGate(toRoomCode);
        } else {
            return new SensorGate(toRoomCode);
        }
    }
}
