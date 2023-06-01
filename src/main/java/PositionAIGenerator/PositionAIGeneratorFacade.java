package PositionAIGenerator;

import GameState.GameStateConfiguration;
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
        char[][] mapChars = mapToArrayCharMapper.transformMapToCharArray(currentTicTacToeMap);
        Move bestMove = minMaxAlgorithmGenerator.findBestMove(mapChars);
        PositionDto positionDtoResult = PositionDto.builder()
                .x(bestMove.row)
                .y(bestMove.col)
                .build();
        return positionDtoResult;
    }

    public static void main(String[] args) {
        PositionAIGeneratorConfiguration positionAIGeneratorConfiguration = new PositionAIGeneratorConfiguration();
        Map<PositionDto, Character> map = new HashMap<>();

        map.put(new PositionDto(0, 0), ' ');
        map.put(new PositionDto(0, 1), 'X');
        map.put(new PositionDto(0, 2), ' ');
        map.put(new PositionDto(1, 0), 'O');
        map.put(new PositionDto(1, 1), 'O');
        map.put(new PositionDto(1, 2), 'X');
        map.put(new PositionDto(2, 0), ' ');
        map.put(new PositionDto(2, 1), ' ');
        map.put(new PositionDto(2, 2), ' ');

        GameStateFacade gameStateFacade1 = new GameStateFacade(map);
        PositionAIGeneratorFacade positionAIGeneratorFacade =
                positionAIGeneratorConfiguration.positionAIGeneratorFacade(gameStateFacade1);

        Map<PositionDto, Character> currentTicTacToeMap = positionAIGeneratorFacade.gameStateFacade.getCurrentTicTacToeMap();

        char[][] chars = positionAIGeneratorFacade.mapToArrayCharMapper.transformMapToCharArray(currentTicTacToeMap);

        System.out.println(Arrays.deepToString(chars));

        PositionDto positionDto = positionAIGeneratorFacade.positionGenerator();
        System.out.println(positionDto);

    }


}
