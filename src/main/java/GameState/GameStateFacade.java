package GameState;


import PositionAIGenerator.PositionAIGeneratorFacade;
import PositionReceiver.dto.PositionDto;

import java.util.Map;

public class GameStateFacade {

    Map<PositionDto, Character> ticTacToeMap;
    PositionAIGeneratorFacade positionAIGeneratorFacade;

    public GameStateFacade(Map<PositionDto, Character> ticTacToeMap) {
        this.ticTacToeMap = ticTacToeMap;
    }

    public Map<PositionDto, Character> getCurrentTicTacToeMap() {
        return ticTacToeMap;
    }

    public Character inputPosition(PositionDto position, Character sign) {
        Character resultOfAdd = ticTacToeMap.put(position, sign);
        return resultOfAdd;
    }

//    public PositionDto getPositionOfAi() {
//        PositionDto positionDto = positionAIGeneratorFacade.positionGenerator();
////        throw new RuntimeException("should return position of AI");
//        return positionDto;
//    }


}
