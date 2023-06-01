package PositionAIGenerator;

import PositionReceiver.dto.PositionDto;

import java.util.Map;

class MapToArrayCharMapper {
    char[][] transformMapToCharArray(Map<PositionDto, Character> mapTicTacToe) {

        char[][] result = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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
