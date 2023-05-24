package PositionReceiver;

import GameState.GameStateFacade;
import PositionReceiver.dto.PositionDto;
import PositionReceiver.dto.PositionReceiverResultDto;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PositionReceiverFacadeTest {


    @Test
    void should_return_that_positionIsEmpty_everything_works() {
        //given
        Map<PositionDto, Character> map = new HashMap<>();
        initializeMap1(map);

        GameStateFacade gameStateFacade = new GameStateFacade(map);

        PositionReceiverFacade positionReceiverFacade = new PositionReceiverConfiguration()
                .positionReceiverFacadeTest(gameStateFacade);

        int x = 1;
        int y = 1;
        Position position = new Position(x, y);
        //when
        PositionReceiverResultDto resultDto = positionReceiverFacade.inputPosition(position);
        //then
        PositionDto positionDtoExpected = new PositionDto(x, y);
        PositionReceiverResultDto expected = PositionReceiverResultDto
                .builder()
                .position(positionDtoExpected)
                .message("positionIsEmpty everything works")
                .build();
        assertThat(resultDto).isEqualTo(expected);
    }

    @Test
    void should_return_that_position_Is_Engaged() {
        //given
        Map<PositionDto, Character> map = new HashMap<>();
        initializeMap2(map);

        GameStateFacade gameStateFacade = new GameStateFacade(map);

        PositionReceiverFacade positionReceiverFacade = new PositionReceiverConfiguration()
                .positionReceiverFacadeTest(gameStateFacade);

        int x = 1;
        int y = 1;
        Position position = new Position(x, y);
        //when
        PositionReceiverResultDto resultDto = positionReceiverFacade.inputPosition(position);
        //then
        PositionDto positionDtoExpected = new PositionDto(x, y);
        PositionReceiverResultDto expected = PositionReceiverResultDto
                .builder()
                .position(positionDtoExpected)
                .message("positionIsEngaged")
                .build();
        assertThat(resultDto).isEqualTo(expected);
    }

    @Test
    void should_return_that_position_Is_Out_Of_The_Box() {
        //given
        Map<PositionDto, Character> map = new HashMap<>();
        initializeMap2(map);

        GameStateFacade gameStateFacade = new GameStateFacade(map);

        PositionReceiverFacade positionReceiverFacade = new PositionReceiverConfiguration()
                .positionReceiverFacadeTest(gameStateFacade);

        int x = -1;
        int y = -1;
        Position position = new Position(x, y);
        //when
        PositionReceiverResultDto resultDto = positionReceiverFacade.inputPosition(position);
        //then
        PositionDto positionDtoExpected = new PositionDto(x, y);
        PositionReceiverResultDto expected = PositionReceiverResultDto
                .builder()
                .position(positionDtoExpected)
                .message("positionIsOutOfTheBox")
                .build();
        assertThat(resultDto).isEqualTo(expected);
    }

    private void initializeMap1(Map<PositionDto, Character> positionCharacterMap) {
        positionCharacterMap.put(new PositionDto(0, 1), null);
        positionCharacterMap.put(new PositionDto(0, 2), null);
        positionCharacterMap.put(new PositionDto(0, 3), null);
        positionCharacterMap.put(new PositionDto(1, 1), null);
        positionCharacterMap.put(new PositionDto(1, 2), null);
        positionCharacterMap.put(new PositionDto(1, 3), null);
        positionCharacterMap.put(new PositionDto(2, 1), null);
        positionCharacterMap.put(new PositionDto(2, 2), null);
        positionCharacterMap.put(new PositionDto(2, 3), null);
    }

    private void initializeMap2(Map<PositionDto, Character> positionCharacterMap) {
        positionCharacterMap.put(new PositionDto(0, 1), null);
        positionCharacterMap.put(new PositionDto(0, 2), null);
        positionCharacterMap.put(new PositionDto(0, 3), null);
        positionCharacterMap.put(new PositionDto(1, 1), 'X');
        positionCharacterMap.put(new PositionDto(1, 2), null);
        positionCharacterMap.put(new PositionDto(1, 3), null);
        positionCharacterMap.put(new PositionDto(2, 1), null);
        positionCharacterMap.put(new PositionDto(2, 2), null);
        positionCharacterMap.put(new PositionDto(2, 3), null);
    }

}