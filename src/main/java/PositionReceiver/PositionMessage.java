package PositionReceiver;

import java.util.Collection;

enum PositionMessage   {
    positionIsEngaged("positionIsEngaged"),

    positionIsEmpty("positionIsEmpty everything works"),

    positionIsOutOfTheBox("positionIsOutOfTheBox");

    final String message;

    PositionMessage(String message) {
        this.message = message;
    }
}
