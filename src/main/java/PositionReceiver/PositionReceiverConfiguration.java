package PositionReceiver;

import GameState.GameStateFacade;

public class PositionReceiverConfiguration {

    public PositionReceiverFacade positionReceiverFacade(GameStateFacade gameStateFacade) {
        PositionChecker positionChecker = new PositionChecker(gameStateFacade);
        return new PositionReceiverFacade(gameStateFacade, positionChecker);
    }

    public PositionReceiverFacade positionReceiverFacadeTest(GameStateFacade gameStateFacade) {
        PositionChecker positionChecker = new PositionChecker(gameStateFacade);
        return new PositionReceiverFacade(gameStateFacade, positionChecker);
    }
}