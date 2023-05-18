package PositionReceiver.dto;

import PositionReceiver.Position;
import lombok.Builder;

@Builder
public record PositionReceiverResultDto(String message, Position position) {
}
