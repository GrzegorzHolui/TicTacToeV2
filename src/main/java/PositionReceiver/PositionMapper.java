package PositionReceiver;

import PositionReceiver.dto.PositionDto;
 class PositionMapper {

    public static PositionDto mapPositionToDto(Position position) {
        return PositionDto.builder()
                .x(position.x)
                .y(position.y)
                .build();
    }
}
