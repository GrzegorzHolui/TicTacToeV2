package PositionAIGenerator;

import GameState.GameStateFacade;
import PositionReceiver.dto.PositionDto;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class PositionAIGeneratorFacadeTest {

    @Test
    void should_return_good_value_of_the_position() {

        //given
        Map<PositionDto, Character> map = new HashMap<>();

        map.put(new PositionDto(0, 0), ' ');
        map.put(new PositionDto(0, 1), 'X');
        map.put(new PositionDto(0, 2), ' ');
        map.put(new PositionDto(1, 0), 'O');
        map.put(new PositionDto(1, 1), 'O');
        map.put(new PositionDto(1, 2), 'X');
        map.put(new PositionDto(2, 0), ' ');
        map.put(new PositionDto(2, 1), ' ');
        map.put(new PositionDto(2, 2), ' ');

        PositionAIGeneratorConfiguration positionAIGeneratorConfiguration = new PositionAIGeneratorConfiguration();
        PositionAIGeneratorFacade positionAIGeneratorFacade =
                positionAIGeneratorConfiguration.positionAIGeneratorFacadeTest(new GameStateFacade(map));

        //when
        PositionDto result = positionAIGeneratorFacade.positionGenerator();

        //then
        PositionDto expected = new PositionDto(0, 2);
        assertThat(result).isEqualTo(expected);
    }
}