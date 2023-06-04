package PositionAIGenerator;

import PositionReceiver.dto.PositionDto;

import java.util.Map;

class MapToArrayCharMapper {
    char[][] transformMapToCharArray(Map<PositionDto, Character> mapTicTacToe) {
        int size = (int) Math.sqrt(mapTicTacToe.size());
        char[][] result = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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
