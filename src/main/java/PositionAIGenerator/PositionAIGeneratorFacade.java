package PositionAIGenerator;

import GameState.GameStateFacade;
import PositionReceiver.dto.PositionDto;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class PositionAIGeneratorFacade {

    GameStateFacade gameStateFacade;
    MinMaxAlgorithmGenerator minMaxAlgorithmGenerator;
    MapToArrayCharMapper mapToArrayCharMapper;

    public PositionDto positionGenerator() {
        Map<PositionDto, Character> currentTicTacToeMap = gameStateFacade.getCurrentTicTacToeMap();
        char[][] mapChars = mapToArrayCharMapper.transformMapToCharArray(currentTicTacToeMap,gameStateFacade.getDimensionsOfTicTacToe());
        int[] bestMove = minMaxAlgorithmGenerator.getBestMove
                (mapChars, gameStateFacade.getDimensionsOfTicTacToe(), gameStateFacade.getRowToWin(), 1);
        PositionDto positionDtoResult = PositionDto.builder()
                .x(bestMove[0])
                .y(bestMove[1])
                .build();
        return positionDtoResult;
    }

//    public static void main(String[] args) {
//        PositionAIGeneratorConfiguration positionAIGeneratorConfiguration = new PositionAIGeneratorConfiguration();
//        Map<PositionDto, Character> map = new HashMap<>();
//
//        map.put(new PositionDto(0, 0), 'X');
//        map.put(new PositionDto(0, 1), 'X');
//        map.put(new PositionDto(0, 2), 'O');
//        map.put(new PositionDto(1, 0), 'O');
//        map.put(new PositionDto(1, 1), 'O');
//        map.put(new PositionDto(1, 2), 'X');
//        map.put(new PositionDto(2, 0), 'X');
//        map.put(new PositionDto(2, 1), 'O');
//        map.put(new PositionDto(2, 2), 'O');
//
//        GameStateFacade gameStateFacade1 = new GameStateFacade(map);
//        PositionAIGeneratorFacade positionAIGeneratorFacade =
//                positionAIGeneratorConfiguration.positionAIGeneratorFacade(gameStateFacade1);
//
//        Map<PositionDto, Character> currentTicTacToeMap = positionAIGeneratorFacade.gameStateFacade.getCurrentTicTacToeMap();
//
//        char[][] chars = positionAIGeneratorFacade.mapToArrayCharMapper.transformMapToCharArray(currentTicTacToeMap,
//                gameStateFacade.getDimensionsOfTicTacToe());
//
//        System.out.println(Arrays.deepToString(chars));
//
//        PositionDto positionDto = positionAIGeneratorFacade.positionGenerator();
//        System.out.println(positionDto);
//
//    }


}
