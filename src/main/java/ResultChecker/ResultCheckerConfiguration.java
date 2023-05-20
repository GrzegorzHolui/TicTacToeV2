package ResultChecker;

import PositionReceiver.PositionReceiverFacade;

public class ResultCheckerConfiguration {

    public ResultCheckerFacade positionReceiverFacade() {
        return new ResultCheckerFacade();
    }

    public ResultCheckerFacade positionReceiverFacadeTest() {
        return new ResultCheckerFacade();
    }
}
