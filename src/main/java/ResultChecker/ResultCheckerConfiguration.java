package ResultChecker;

import GameState.GameStateFacade;
import PositionReceiver.PositionReceiverFacade;
import PositionReceiver.dto.PositionDto;

import java.util.Map;

public class ResultCheckerConfiguration {

    public ResultCheckerFacade positionReceiverFacade(GameStateFacade gameStateFacade) {
        TicTacToeJudge ticTacToeJudge = new TicTacToeJudge(gameStateFacade);
        return new ResultCheckerFacade(ticTacToeJudge);
    }

    public ResultCheckerFacade positionReceiverFacadeTest(Map<PositionDto, Character> map, int dimensions, int rowToWin) {
        GameStateFacade gameStateFacade = new GameStateFacade(map, dimensions, rowToWin);
        TicTacToeJudge ticTacToeJudge = new TicTacToeJudge(gameStateFacade);
        return new ResultCheckerFacade(ticTacToeJudge);
    }
}
