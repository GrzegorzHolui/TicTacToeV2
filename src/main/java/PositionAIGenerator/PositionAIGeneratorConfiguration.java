package PositionAIGenerator;

import GameState.GameStateFacade;

public class PositionAIGeneratorConfiguration {

    public PositionAIGeneratorFacade positionAIGeneratorFacade(GameStateFacade gameStateFacade) {
        MinMaxAlgorithmGenerator minMaxAlgorithmGenerator = new MinMaxAlgorithmGenerator();
        MapToArrayCharMapper mapToArrayCharMapper = new MapToArrayCharMapper();
        return new PositionAIGeneratorFacade(gameStateFacade, minMaxAlgorithmGenerator, mapToArrayCharMapper);
    }

    public PositionAIGeneratorFacade positionAIGeneratorFacadeTest(GameStateFacade gameStateFacade) {
        MinMaxAlgorithmGenerator minMaxAlgorithmGenerator = new MinMaxAlgorithmGenerator();
        MapToArrayCharMapper mapToArrayCharMapper = new MapToArrayCharMapper();
        return new PositionAIGeneratorFacade(gameStateFacade, minMaxAlgorithmGenerator, mapToArrayCharMapper);
    }
}
