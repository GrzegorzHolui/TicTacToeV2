package PositionReceiver;

import GameState.GameStateFacade;
import PositionReceiver.dto.PositionDto;
import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
class PositionChecker {

    private static char emptyField = '-';
    GameStateFacade gameStateFacade;

    public PositionMessage checkPosition(PositionDto position) {
        int dimensions = gameStateFacade.getDimensionsOfTicTacToe();

        PositionMessage result = null;

        Map<PositionDto, Character> currentTicTacToeMap = gameStateFacade.getCurrentTicTacToeMap();

        if (position.x() > dimensions || position.x() < 0 || position.y() > dimensions || position.y() < 0) {
            result = PositionMessage.positionIsOutOfTheBox;
        } else if (isValueAtPosition(position, currentTicTacToeMap)) {
            result = PositionMessage.positionIsEngaged;
        } else {
            result = PositionMessage.positionIsEmpty;
        }

        return result;
    }

    private static boolean isValueAtPosition(PositionDto position, Map<PositionDto, Character> currentTicTacToeMap) {
        Character character = currentTicTacToeMap.get(position);
        if (character == emptyField) {
            return false;
        } else {
            return true;
        }
    }


}
