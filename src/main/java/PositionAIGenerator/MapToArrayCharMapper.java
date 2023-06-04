package PositionAIGenerator;

import PositionReceiver.dto.PositionDto;

import java.util.Map;

class MapToArrayCharMapper {
    char[][] transformMapToCharArray(Map<PositionDto, Character> mapTicTacToe, int dimensionsOfTicTacToe) {
        char[][] result = new char[dimensionsOfTicTacToe][dimensionsOfTicTacToe];
        for (int i = 0; i < dimensionsOfTicTacToe; i++) {
            for (int j = 0; j < dimensionsOfTicTacToe; j++) {
                PositionDto position = new PositionDto(i, j);
                if (mapTicTacToe.containsKey(position)) {
                    result[i][j] = mapTicTacToe.get(position);
                } else {
                    result[i][j] = ' ';
                }
            }
        }
        return result;
    }
}
