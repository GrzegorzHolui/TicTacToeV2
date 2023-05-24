package GameState;


import PositionReceiver.dto.PositionDto;

import java.util.Map;

public class GameStateFacade {

    Map<PositionDto, Character> ticTacToeMap;

    public GameStateFacade(Map<PositionDto, Character> ticTacToeMap) {
        this.ticTacToeMap = ticTacToeMap;
    }

    public Map<PositionDto, Character> getCurrentTicTacToeMap() {
        return ticTacToeMap;
    }

    public Character inputPosition(PositionDto position, Character sign) {
        if (ticTacToeMap.containsKey(position)) {
            return null;
        }
        Character resultOfAdd = ticTacToeMap.put(position, sign);
        return resultOfAdd;
    }


}
