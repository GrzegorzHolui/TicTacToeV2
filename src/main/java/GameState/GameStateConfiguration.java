package GameState;


import PositionAIGenerator.PositionAIGeneratorFacade;
import PositionReceiver.Position;
import PositionReceiver.dto.PositionDto;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameStateConfiguration {

    public GameStateFacade gameStateFacade(Map<PositionDto, Character> positionCharacterMap,int dimensions, int rowToWin) {
        return new GameStateFacade(positionCharacterMap,dimensions,rowToWin);
    }

    public GameStateFacade gameStateFacadeTest(Map<PositionDto, Character> positionCharacterMap,int dimensions, int rowToWin) {
        return new GameStateFacade(positionCharacterMap,dimensions,rowToWin);
    }


}
