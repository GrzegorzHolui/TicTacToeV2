package ResultChecker;

import PositionReceiver.PositionReceiverFacade;

public class ResultCheckerConfiguration {

    public ResultCheckerFacade positionReceiverFacade() {
        TicTacToeJudge ticTacToeJudge = new TicTacToeJudge();
        return new ResultCheckerFacade(ticTacToeJudge);
    }

    public ResultCheckerFacade positionReceiverFacadeTest() {
        TicTacToeJudge ticTacToeJudge = new TicTacToeJudge();
        return new ResultCheckerFacade(ticTacToeJudge);
    }
}
