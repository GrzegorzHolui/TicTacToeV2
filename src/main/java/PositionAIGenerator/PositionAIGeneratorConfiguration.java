package PositionAIGenerator;

import GameState.GameStateFacade;

public class PositionAIGeneratorConfiguration {

    public PositionAIGeneratorFacade positionAIGeneratorFacade(GameStateFacade gameStateFacade) {
        return new PositionAIGeneratorFacade(gameStateFacade);
    }

    public PositionAIGeneratorFacade positionAIGeneratorFacadeTest(GameStateFacade gameStateFacade) {
        return new PositionAIGeneratorFacade(gameStateFacade);
    }
}
