package GameState;

import PositionReceiver.Position;

import java.util.Map;

public class GameStateFacade {

    Map<Position, Character> ticTacToeMap;

    public GameStateFacade(Map<Position, Character> ticTacToeMap) {
        this.ticTacToeMap = ticTacToeMap;
    }

    public Map<Position, Character> getCurrentTicTacToeMap() {
        return ticTacToeMap;
    }

    public Character inputPosition(Position position, Character sign) {
        Character resultOfAdd = ticTacToeMap.put(position, sign);
        return resultOfAdd;
    }


}
