package ResultChecker;

import PositionReceiver.Position;
import ResultChecker.dto.ResultCheckerDto;

import java.util.Map;

public class ResultCheckerFacade {

    private TicTacToeJudge ticTacToeJudge;

    public ResultCheckerFacade(TicTacToeJudge ticTacToeJudge) {
        this.ticTacToeJudge = ticTacToeJudge;
    }

    public ResultCheckerDto checkWhoWin(Map<Position, Character> mapTicTacToe) {
        ResultOfRound result = ticTacToeJudge.decideWhoWon(mapTicTacToe);
        if (result == null) {
            return new ResultCheckerDto(result, null);
        }
        return new ResultCheckerDto(result, "Good");
    }

}