package GameState;


import PositionReceiver.dto.PositionDto;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameStateConfiguration {

    public GameStateFacade gameStateFacade() {
        Map<PositionDto, Character> positionCharacterMap = new LinkedHashMap<>();
        initializeMap(positionCharacterMap);
        return new GameStateFacade(positionCharacterMap);
    }

    public GameStateFacade gameStateFacadeTest() {
        Map<PositionDto, Character> positionCharacterMap = new LinkedHashMap<>();
        return new GameStateFacade(positionCharacterMap);
    }

    private void initializeMap(Map<PositionDto, Character> positionCharacterMap) {
        positionCharacterMap.put(new PositionDto(0, 1), null);
        positionCharacterMap.put(new PositionDto(0, 2), null);
        positionCharacterMap.put(new PositionDto(0, 3), null);
        positionCharacterMap.put(new PositionDto(1, 1), null);
        positionCharacterMap.put(new PositionDto(1, 2), null);
        positionCharacterMap.put(new PositionDto(1, 3), null);
        positionCharacterMap.put(new PositionDto(2, 1), null);
        positionCharacterMap.put(new PositionDto(2, 2), null);
        positionCharacterMap.put(new PositionDto(2, 3), null);
    }
}
