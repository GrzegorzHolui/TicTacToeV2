package ResultChecker;

import PositionReceiver.Position;

import java.util.Map;

public class ResultCheckerFacade {

    TicTacToeJudge ticTacToeJudge;

    public ResultOfRound checkWhoWin(Map<Position, Character> mapTicTacToe) {
        ResultOfRound result = ticTacToeJudge.decideWhoWon(mapTicTacToe);
        return result;
    }
}