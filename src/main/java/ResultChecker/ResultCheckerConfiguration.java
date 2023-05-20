package ResultChecker;

import PositionReceiver.PositionReceiverFacade;

public class ResultCheckerConfiguration {

    public ResultCheckerFacade positionReceiverFacade(TicTacToeJudge ticTacToeJudge) {
        return new ResultCheckerFacade(ticTacToeJudge);
    }

    public ResultCheckerFacade positionReceiverFacadeTest(TicTacToeJudge ticTacToeJudge) {
        return new ResultCheckerFacade(ticTacToeJudge);
    }
}
