package MapDrawer;

import GameState.GameStateFacade;
import PositionReceiver.dto.PositionDto;

import java.util.HashMap;
import java.util.Map;

public class MapDrawerFacade {

    GameStateFacade gameStateFacade;

    public MapDrawerFacade(GameStateFacade gameStateFacade) {
        this.gameStateFacade = gameStateFacade;
    }

    public void printMap() {
        Map<PositionDto, Character> currentTicTacToeMap = gameStateFacade.getCurrentTicTacToeMap();
        int size = gameStateFacade.getDimensionsOfTicTacToe();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Character character = currentTicTacToeMap.get(new PositionDto(i, j));
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//        MapDrawerFacade mapDrawerFacade = new MapDrawerFacade();
//
//        mapDrawerFacade.printMap(initializeMap());
//    }


    private static Map<PositionDto, Character> initializeMap() {
        Map<PositionDto, Character> map = new HashMap<>();
        map.put(new PositionDto(0, 0), 'O');
        map.put(new PositionDto(0, 1), 'O');
        map.put(new PositionDto(0, 2), 'O');
        map.put(new PositionDto(1, 0), 'X');
        map.put(new PositionDto(1, 1), '-');
        map.put(new PositionDto(1, 2), '-');
        map.put(new PositionDto(2, 0), 'X');
        map.put(new PositionDto(2, 1), 'X');
        map.put(new PositionDto(2, 2), 'X');
        return map;
    }


}