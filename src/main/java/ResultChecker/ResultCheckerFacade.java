package ResultChecker;


import GameState.GameStateFacade;
import PositionReceiver.dto.PositionDto;
import ResultChecker.dto.ResultCheckerDto;

import java.util.Map;

public class ResultCheckerFacade {

    private TicTacToeJudge ticTacToeJudge;

    public ResultCheckerFacade(TicTacToeJudge ticTacToeJudge) {
        this.ticTacToeJudge = ticTacToeJudge;
    }

    public ResultCheckerDto checkWhoWin(Map<PositionDto, Character> mapTicTacToe) {
        ResultOfRound result = ticTacToeJudge.decideWhoWon(mapTicTacToe);
        if (result == null) {
            return new ResultCheckerDto(result, null);
        }
        return new ResultCheckerDto(result, result.message);
    }

}