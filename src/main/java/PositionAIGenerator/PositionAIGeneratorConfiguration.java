package PositionAIGenerator;

import GameState.GameStateFacade;

import PositionReceiver.PositionReceiverFacade;

public class PositionAIGeneratorConfiguration {

    public PositionAIGeneratorFacade PositionAIGeneratorFacade(GameStateFacade gameStateFacade) {
        return new PositionAIGeneratorFacade(gameStateFacade);
    }

    public PositionAIGeneratorFacade PositionAIGeneratorFacadeTest(GameStateFacade gameStateFacade) {
        return new PositionAIGeneratorFacade(gameStateFacade);
    }
}
