package GameState;

import PositionReceiver.dto.PositionDto;

import java.util.Map;

public class GameStateFacade {

    private Map<PositionDto, Character> ticTacToeMap;
    private int dimensionsOfTicTacToe;

    public GameStateFacade(Map<PositionDto, Character> ticTacToeMap) {
        this.ticTacToeMap = ticTacToeMap;
    }

    public GameStateFacade(Map<PositionDto, Character> ticTacToeMap, int dimensionsOfTicTacToe) {
        this.ticTacToeMap = ticTacToeMap;
        this.dimensionsOfTicTacToe = dimensionsOfTicTacToe;
    }

    public Map<PositionDto, Character> getCurrentTicTacToeMap() {
        return ticTacToeMap;
    }

    public Character inputPosition(PositionDto position, Character sign) {
        Character resultOfAdd = ticTacToeMap.put(position, sign);
        return resultOfAdd;
    }

    public void setDimensions(int dimensions) {
//        initiazlizeMap();
        this.dimensionsOfTicTacToe = dimensions;
    }

    public int getDimensionsOfTicTacToe() {
        return dimensionsOfTicTacToe;
    }
    //    public PositionDto getPositionOfAi() {
//        PositionDto positionDto = positionAIGeneratorFacade.positionGenerator();
////        throw new RuntimeException("should return position of AI");
//        return positionDto;
//    }

//    private void initializeMap(Map<PositionDto, Character> positionCharacterMap) {
//        positionCharacterMap.put(new PositionDto(0, 0), ' ');
//        positionCharacterMap.put(new PositionDto(0, 1), ' ');
//        positionCharacterMap.put(new PositionDto(0, 2), ' ');
//        positionCharacterMap.put(new PositionDto(1, 0), ' ');
//        positionCharacterMap.put(new PositionDto(1, 1), ' ');
//        positionCharacterMap.put(new PositionDto(1, 2), ' ');
//        positionCharacterMap.put(new PositionDto(2, 0), ' ');
//        positionCharacterMap.put(new PositionDto(2, 1), ' ');
//        positionCharacterMap.put(new PositionDto(2, 2), ' ');
//    }


}
