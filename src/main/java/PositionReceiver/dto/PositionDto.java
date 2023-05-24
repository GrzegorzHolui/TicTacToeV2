package PositionReceiver.dto;

import lombok.Builder;

@Builder
public record PositionDto(int x, int y) {
}
