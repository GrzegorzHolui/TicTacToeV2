package GameState;

import PositionReceiver.Position;
import PositionReceiver.PositionReceiverFacade;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameStateConfiguration {

    public GameStateFacade gameStateFacade() {
        Map<Position, Character> positionCharacterMap = new LinkedHashMap<>();
        initializeMap(positionCharacterMap);
        return new GameStateFacade(positionCharacterMap);
    }

    public GameStateFacade gameStateFacadeTest() {
        Map<Position, Character> positionCharacterMap = new LinkedHashMap<>();
        return new GameStateFacade(positionCharacterMap);
    }

    private void initializeMap(Map<Position, Character> positionCharacterMap) {
        positionCharacterMap.put(new Position(0, 1), null);
        positionCharacterMap.put(new Position(0, 2), null);
        positionCharacterMap.put(new Position(0, 3), null);
        positionCharacterMap.put(new Position(1, 1), null);
        positionCharacterMap.put(new Position(1, 2), null);
        positionCharacterMap.put(new Position(1, 3), null);
        positionCharacterMap.put(new Position(2, 1), null);
        positionCharacterMap.put(new Position(2, 2), null);
        positionCharacterMap.put(new Position(2, 3), null);
    }
}
