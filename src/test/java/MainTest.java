import GameState.GameStateConfiguration;
import GameState.GameStateFacade;
import PositionAIGenerator.PositionAIGeneratorConfiguration;
import PositionAIGenerator.PositionAIGeneratorFacade;
import PositionReceiver.Position;
import PositionReceiver.PositionReceiverConfiguration;
import PositionReceiver.PositionReceiverFacade;
import PositionReceiver.dto.PositionDto;
import ResultChecker.ResultCheckerConfiguration;
import ResultChecker.ResultCheckerFacade;
import ResultChecker.dto.ResultCheckerDto;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class MainTest {

    @Test
    void shouldReturnThatNoneWon() {
        //given
        GameStateConfiguration gameStateConfiguration = new GameStateConfiguration();

        PositionAIGeneratorConfiguration positionAIGeneratorConfiguration
                = new PositionAIGeneratorConfiguration();
        PositionReceiverConfiguration positionReceiverConfiguration = new PositionReceiverConfiguration();
        ResultCheckerConfiguration resultCheckerConfiguration = new ResultCheckerConfiguration();

        GameStateFacade gameStateFacade = gameStateConfiguration.gameStateFacadeTest();

        PositionReceiverFacade positionReceiverFacade =
                positionReceiverConfiguration.positionReceiverFacadeTest(gameStateFacade);

        PositionAIGeneratorFacade positionAIGeneratorFacade = mock(PositionAIGeneratorFacade.class);

        ResultCheckerFacade resultCheckerFacade = resultCheckerConfiguration.positionReceiverFacadeTest();

        //when
        Position userPosition = new Position(1, 1);
        PositionDto position = positionReceiverFacade.inputPosition(userPosition).position();

        gameStateFacade.inputPosition(position, 'X');

        PositionDto positionOfAI = new PositionDto(1, 2);

        given(positionAIGeneratorFacade.positionGenerator()).willReturn(positionOfAI);

        PositionDto positionAiDto = positionAIGeneratorFacade.positionGenerator();

        gameStateFacade.inputPosition(positionAiDto, 'O');

        Map<PositionDto, Character> currentTicTacToeMap = gameStateFacade.getCurrentTicTacToeMap();
        ResultCheckerDto resultCheckerDto = resultCheckerFacade.checkWhoWin(currentTicTacToeMap);

        assertThat(resultCheckerDto.message()).isEqualTo("No one won");
    }


}