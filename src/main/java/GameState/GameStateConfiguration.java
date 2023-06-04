package GameState;


import PositionAIGenerator.PositionAIGeneratorFacade;
import PositionReceiver.Position;
import PositionReceiver.dto.PositionDto;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameStateConfiguration {

    public GameStateFacade gameStateFacade() {
        Map<PositionDto, Character> positionCharacterMap = new LinkedHashMap<>();
        return new GameStateFacade(positionCharacterMap);
    }

    public GameStateFacade gameStateFacadeTest() {
        Map<PositionDto, Character> positionCharacterMap = new LinkedHashMap<>();
        return new GameStateFacade(positionCharacterMap);
    }


}
