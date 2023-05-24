package PositionAIGenerator;

import GameState.GameStateFacade;
import PositionReceiver.dto.PositionDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PositionAIGeneratorFacade {

    GameStateFacade gameStateFacade;

    public PositionDto positionGenerator() {
        throw new RuntimeException("Should be here code of Algorithm Min-MAX");
    }
}
