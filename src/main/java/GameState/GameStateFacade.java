package GameState;

import PositionReceiver.dto.PositionDto;

import java.util.Map;

public class GameStateFacade {

    private Map<PositionDto, Character> ticTacToeMap;
    private int dimensionsOfTicTacToe;

    private int rowToWin;

    public GameStateFacade(Map<PositionDto, Character> ticTacToeMap, int dimensionsOfTicTacToe, int rowToWin) {
        this.ticTacToeMap = ticTacToeMap;
        this.dimensionsOfTicTacToe = dimensionsOfTicTacToe;
        this.rowToWin = rowToWin;
    }

    public int getRowToWin() {
        return rowToWin;
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

    public boolean isBoardFull() {
        for (Character value : ticTacToeMap.values()) {
            if (value == '-') {
                return false;
            }
        }
        return true;
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
