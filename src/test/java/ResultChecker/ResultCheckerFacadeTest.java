package ResultChecker;

import PositionReceiver.dto.PositionDto;
import ResultChecker.dto.ResultCheckerDto;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultCheckerFacadeTest {

    @Test
    void should_return_that_user_won_user_inputted_X_by_diagonal() {
        //given
        Map<PositionDto, Character> map = new HashMap<>();
        map.put(new PositionDto(0, 0), 'X');
        map.put(new PositionDto(1, 0), 'O');
        map.put(new PositionDto(2, 0), 'O');
        map.put(new PositionDto(0, 0), 'X');
        map.put(new PositionDto(0, 1), 'X');
        map.put(new PositionDto(1, 1), 'X');
        map.put(new PositionDto(2, 2), 'X');

        ResultCheckerFacade resultCheckerFacade = new ResultCheckerConfiguration()
                .positionReceiverFacadeTest(map, 3, 3);

        //when
        ResultCheckerDto result = resultCheckerFacade.checkWhoWin(map);
        //then
        ResultOfRound expected = ResultOfRound.UserWon;
        assertThat(result.result().message).isEqualTo(expected.message);
    }

    @Test
    void should_return_that_user_won_user_inputted_X_by_row() {
        //given
        Map<PositionDto, Character> map = new HashMap<>();
        map.put(new PositionDto(0, 0), 'X');
        map.put(new PositionDto(1, 0), 'X');
        map.put(new PositionDto(2, 0), 'X');
        map.put(new PositionDto(0, 1), 'O');
        map.put(new PositionDto(1, 1), 'O');
        map.put(new PositionDto(0, 2), 'O');
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerConfiguration()
                .positionReceiverFacadeTest(map, 3, 3);
        //when
        ResultCheckerDto result = resultCheckerFacade.checkWhoWin(map);
        //then
        ResultOfRound expected = ResultOfRound.UserWon;
        assertThat(result.result().message).isEqualTo(expected.message);
    }

    @Test
    void should_return_that_user_won_user_inputted_X_by_column() {
        //given
        Map<PositionDto, Character> map = new HashMap<>();
        map.put(new PositionDto(0, 0), 'X');
        map.put(new PositionDto(0, 1), 'X');
        map.put(new PositionDto(0, 2), 'X');
        map.put(new PositionDto(1, 1), 'O');
        map.put(new PositionDto(2, 2), 'O');
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerConfiguration()
                .positionReceiverFacadeTest(map, 3, 3);

        //when
        ResultCheckerDto result = resultCheckerFacade.checkWhoWin(map);
        //then
        ResultOfRound expected = ResultOfRound.UserWon;
        assertThat(result.result().message).isEqualTo(expected.message);
    }

    @Test
    void should_return_that_AI_won_user_inputted_X_by_diagonal() {
        //given
        Map<PositionDto, Character> map = new HashMap<>();
        map.put(new PositionDto(2, 0), 'O');
        map.put(new PositionDto(1, 1), 'O');
        map.put(new PositionDto(0, 2), 'O');

        map.put(new PositionDto(0, 0), 'X');
        map.put(new PositionDto(0, 1), 'X');
        map.put(new PositionDto(2, 2), 'X');
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerConfiguration()
                .positionReceiverFacadeTest(map, 3, 3);

        //when
        ResultCheckerDto result = resultCheckerFacade.checkWhoWin(map);
        //then
        ResultOfRound expected = ResultOfRound.AIWon;
        assertThat(result.result().message).isEqualTo(expected.message);
    }

    @Test
    void should_return_that_AI_won_user_inputted_X_by_row() {
        //given
        Map<PositionDto, Character> map = new HashMap<>();

        map.put(new PositionDto(0, 1), 'O');
        map.put(new PositionDto(1, 1), 'O');
        map.put(new PositionDto(2, 1), 'O');
        map.put(new PositionDto(1, 2), 'O');
        map.put(new PositionDto(0, 0), 'X');
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerConfiguration()
                .positionReceiverFacadeTest(map, 3, 3);
        //when
        ResultCheckerDto result = resultCheckerFacade.checkWhoWin(map);
        //then
        ResultOfRound expected = ResultOfRound.AIWon;
        assertThat(result.result().message).isEqualTo(expected.message);
    }

    @Test
    void should_return_that_AI_won_user_inputted_X_by_column() {
        //given
        Map<PositionDto, Character> map = new HashMap<>();
        map.put(new PositionDto(1, 0), 'O');
        map.put(new PositionDto(1, 1), 'O');
        map.put(new PositionDto(1, 2), 'O');
        map.put(new PositionDto(0, 0), 'X');
        map.put(new PositionDto(0, 1), 'O');
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerConfiguration()
                .positionReceiverFacadeTest(map, 3, 3);

        //when
        ResultCheckerDto result = resultCheckerFacade.checkWhoWin(map);
        //then
        ResultOfRound expected = ResultOfRound.AIWon;
        assertThat(result.result().message).isEqualTo(expected.message);
    }

    @Test
    void should_return_that_AI_won() {
        //given
        Map<PositionDto, Character> map = new HashMap<>();
        map.put(new PositionDto(0, 0), 'O');
        map.put(new PositionDto(0, 1), 'O');
        map.put(new PositionDto(0, 2), 'O');
        map.put(new PositionDto(0, 3), 'O');
        map.put(new PositionDto(1, 0), '-');
        map.put(new PositionDto(1, 1), '-');
        map.put(new PositionDto(1, 2), '-');
        map.put(new PositionDto(1, 3), '-');
        map.put(new PositionDto(2, 0), '-');
        map.put(new PositionDto(2, 1), 'X');
        map.put(new PositionDto(2, 2), '-');
        map.put(new PositionDto(2, 3), 'X');
        map.put(new PositionDto(3, 0), 'X');
        map.put(new PositionDto(3, 1), '-');
        map.put(new PositionDto(3, 2), '-');
        map.put(new PositionDto(3, 3), '-');

        ResultCheckerFacade resultCheckerFacade = new ResultCheckerConfiguration()
                .positionReceiverFacadeTest(map, 4, 4);

        //when
        ResultCheckerDto result = resultCheckerFacade.checkWhoWin(map);
        //then
        ResultOfRound expected = ResultOfRound.AIWon;
        assertThat(result.result().message).isEqualTo(expected.message);
    }

}