package MapDrawer;

import GameState.GameStateFacade;
import PositionAIGenerator.PositionAIGeneratorFacade;

public class MapDrawerConfiguration {


    public MapDrawerFacade MapDrawerFacadeFacade() {
        return new MapDrawerFacade();
    }

    public MapDrawerFacade MapDrawerFacadeFacadeTest() {
        return new MapDrawerFacade();
    }
}
