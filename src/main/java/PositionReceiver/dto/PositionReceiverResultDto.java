package PositionReceiver.dto;


import lombok.Builder;

@Builder
public record PositionReceiverResultDto(String message, PositionDto position) {
}
