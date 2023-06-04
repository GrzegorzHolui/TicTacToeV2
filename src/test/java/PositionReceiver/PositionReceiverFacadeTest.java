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
    void should_return_that_positionIsEmpty_everything_works1() {
        //given
        Map<PositionDto, Character> map = new HashMap<>();
        initializeMap(map, 3);

        GameStateFacade gameStateFacade = new GameStateFacade(map, 3,3);

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
    void should_return_that_positionIsEmpty_everything_works2() {
        //given
        Map<PositionDto, Character> map = new HashMap<>();
        initializeMap(map, 10);

        GameStateFacade gameStateFacade = new GameStateFacade(map, 10,3);

        PositionReceiverFacade positionReceiverFacade = new PositionReceiverConfiguration()
                .positionReceiverFacadeTest(gameStateFacade);

        int x = 9;
        int y = 9;
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
        initializeMap(map);

        GameStateFacade gameStateFacade = new GameStateFacade(map, 3,3);

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
        initializeMap(map);

        GameStateFacade gameStateFacade = new GameStateFacade(map, 3,3);

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

    private void initializeMap(Map<PositionDto, Character> positionCharacterMap, int dimensions) {
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                PositionDto positionDto = new PositionDto(i, j);
                positionCharacterMap.put(positionDto, '-');
            }
        }
    }

    private void initializeMap(Map<PositionDto, Character> positionCharacterMap) {
        positionCharacterMap.put(new PositionDto(0, 1), '-');
        positionCharacterMap.put(new PositionDto(0, 2), '-');
        positionCharacterMap.put(new PositionDto(0, 3), '-');
        positionCharacterMap.put(new PositionDto(1, 1), 'X');
        positionCharacterMap.put(new PositionDto(1, 2), '-');
        positionCharacterMap.put(new PositionDto(1, 3), '-');
        positionCharacterMap.put(new PositionDto(2, 1), '-');
        positionCharacterMap.put(new PositionDto(2, 2), '-');
        positionCharacterMap.put(new PositionDto(2, 3), '-');
    }

}