package MapDrawer;

import GameState.GameStateFacade;
import PositionAIGenerator.PositionAIGeneratorFacade;

public class MapDrawerConfiguration {


    public MapDrawerFacade MapDrawerFacadeFacade(GameStateFacade gameStateFacade) {
        return new MapDrawerFacade(gameStateFacade);
    }

    public MapDrawerFacade MapDrawerFacadeFacadeTest(GameStateFacade gameStateFacade) {
        return new MapDrawerFacade(gameStateFacade);
    }
}
