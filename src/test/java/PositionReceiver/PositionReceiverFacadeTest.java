package PositionReceiver;

import PositionReceiver.dto.PositionReceiverResultDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionReceiverFacadeTest {


    @Test
    void should_return_that_good_position_is_inputted() {
        //given
        PositionReceiverFacade positionReceiverFacade = new PositionReceiverConfiguration()
                .positionReceiverFacadeTest();
        int x = 1;
        int y = 1;
        Position position = new Position(x, y);
        //when
        PositionReceiverResultDto resultDto = positionReceiverFacade.inputPosition(position);
        //then
        PositionReceiverResultDto expected = PositionReceiverResultDto
                .builder()
                .position(position)
                .message("GoodPosition")
                .build();
        assertThat(resultDto).isEqualTo(expected);
    }

}