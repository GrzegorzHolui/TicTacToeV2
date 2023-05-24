package PositionReceiver;


import GameState.GameStateFacade;
import PositionReceiver.dto.PositionDto;
import PositionReceiver.dto.PositionReceiverResultDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PositionReceiverFacade {

    GameStateFacade gameStateFacade;
    PositionChecker positionChecker;

    public PositionReceiverResultDto inputPosition(Position position) {

        PositionDto resultPosition = PositionMapper.mapPositionToDto(position);
        PositionMessage checkPosition = positionChecker.checkPosition(resultPosition);
        String message = "";
        if (checkPosition.message.equals("positionIsEngaged")) {
            message = "positionIsEngaged";
        } else if (checkPosition.message.equals("positionIsEmpty everything works")) {
            message = "positionIsEmpty everything works";
        } else if (checkPosition.message.equals("positionIsOutOfTheBox")) {
            message = "positionIsOutOfTheBox";
        }

        return PositionReceiverResultDto.builder()
                .position(resultPosition)
                .message(message)
                .build();

    }
}
