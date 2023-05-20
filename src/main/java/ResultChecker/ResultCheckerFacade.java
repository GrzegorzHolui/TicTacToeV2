package ResultChecker;

import PositionReceiver.Position;

import java.util.Map;

public class ResultCheckerFacade {

    private TicTacToeJudge ticTacToeJudge;
    public ResultCheckerFacade(TicTacToeJudge ticTacToeJudge) {
        this.ticTacToeJudge = ticTacToeJudge;
    }

    public ResultOfRound checkWhoWin(Map<Position, Character> mapTicTacToe) {
        ResultOfRound result = ticTacToeJudge.decideWhoWon(mapTicTacToe);
        return result;
    }
}