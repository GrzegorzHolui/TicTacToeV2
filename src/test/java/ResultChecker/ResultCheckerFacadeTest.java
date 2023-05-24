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
        TicTacToeJudge ticTacToeJudge = new TicTacToeJudge();
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerConfiguration()
                .positionReceiverFacadeTest(ticTacToeJudge);
        Map<PositionDto, Character> map = new HashMap<>();
        map.put(new PositionDto(0, 0), 'X');
        map.put(new PositionDto(1, 0), 'O');
        map.put(new PositionDto(2, 0), 'O');
        map.put(new PositionDto(0, 0), 'X');
        map.put(new PositionDto(0, 1), 'X');
        map.put(new PositionDto(1, 1), 'X');
        map.put(new PositionDto(2, 2), 'X');
        //when
        ResultCheckerDto result = resultCheckerFacade.checkWhoWin(map);
        //then
        ResultOfRound expected = ResultOfRound.UserWon;
        assertThat(result.result().message).isEqualTo(expected.message);
        assertThat(result.message()).isEqualTo("Good");
    }

    @Test
    void should_return_that_user_won_user_inputted_X_by_row() {
        //given
        TicTacToeJudge ticTacToeJudge = new TicTacToeJudge();
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerConfiguration()
                .positionReceiverFacadeTest(ticTacToeJudge);
        Map<PositionDto, Character> map = new HashMap<>();
        map.put(new PositionDto(0, 0), 'X');
        map.put(new PositionDto(1, 0), 'X');
        map.put(new PositionDto(2, 0), 'X');
        map.put(new PositionDto(0, 1), 'O');
        map.put(new PositionDto(1, 1), 'O');
        map.put(new PositionDto(0, 2), 'O');
        //when
        ResultCheckerDto result = resultCheckerFacade.checkWhoWin(map);
        //then
        ResultOfRound expected = ResultOfRound.UserWon;
        assertThat(result.result().message).isEqualTo(expected.message);
        assertThat(result.message()).isEqualTo("Good");
    }

    @Test
    void should_return_that_user_won_user_inputted_X_by_column() {
        //given
        TicTacToeJudge ticTacToeJudge = new TicTacToeJudge();
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerConfiguration()
                .positionReceiverFacadeTest(ticTacToeJudge);
        Map<PositionDto, Character> map = new HashMap<>();
        map.put(new PositionDto(0, 0), 'X');
        map.put(new PositionDto(0, 1), 'X');
        map.put(new PositionDto(0, 2), 'X');
        map.put(new PositionDto(1, 1), 'O');
        map.put(new PositionDto(2, 2), 'O');

        //when
        ResultCheckerDto result = resultCheckerFacade.checkWhoWin(map);
        //then
        ResultOfRound expected = ResultOfRound.UserWon;
        assertThat(result.result().message).isEqualTo(expected.message);
        assertThat(result.message()).isEqualTo("Good");
    }

    @Test
    void should_return_that_AI_won_user_inputted_X_by_diagonal() {
        //given
        TicTacToeJudge ticTacToeJudge = new TicTacToeJudge();
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerConfiguration()
                .positionReceiverFacadeTest(ticTacToeJudge);
        Map<PositionDto, Character> map = new HashMap<>();
        map.put(new PositionDto(2, 0), 'O');
        map.put(new PositionDto(1, 1), 'O');
        map.put(new PositionDto(0, 2), 'O');

        map.put(new PositionDto(0, 0), 'X');
        map.put(new PositionDto(0, 1), 'X');
        map.put(new PositionDto(2, 2), 'X');

        //when
        ResultCheckerDto result = resultCheckerFacade.checkWhoWin(map);
        //then
        ResultOfRound expected = ResultOfRound.AIWon;
        assertThat(result.result().message).isEqualTo(expected.message);
        assertThat(result.message()).isEqualTo("Good");
    }

    @Test
    void should_return_that_AI_won_user_inputted_X_by_row() {
        //given
        TicTacToeJudge ticTacToeJudge = new TicTacToeJudge();
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerConfiguration()
                .positionReceiverFacadeTest(ticTacToeJudge);
        Map<PositionDto, Character> map = new HashMap<>();

        map.put(new PositionDto(0, 1), 'O');
        map.put(new PositionDto(1, 1), 'O');
        map.put(new PositionDto(2, 1), 'O');

        map.put(new PositionDto(1, 2), 'O');
        map.put(new PositionDto(0, 0), 'X');
        //when
        ResultCheckerDto result = resultCheckerFacade.checkWhoWin(map);
        //then
        ResultOfRound expected = ResultOfRound.AIWon;
        assertThat(result.result().message).isEqualTo(expected.message);
        assertThat(result.message()).isEqualTo("Good");
    }

    @Test
    void should_return_that_AI_won_user_inputted_X_by_column() {
        //given
        TicTacToeJudge ticTacToeJudge = new TicTacToeJudge();
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerConfiguration()
                .positionReceiverFacadeTest(ticTacToeJudge);
        Map<PositionDto, Character> map = new HashMap<>();
        map.put(new PositionDto(1, 0), 'O');
        map.put(new PositionDto(1, 1), 'O');
        map.put(new PositionDto(1, 2), 'O');
        map.put(new PositionDto(0, 0), 'X');
        map.put(new PositionDto(0, 1), 'O');

        //when
        ResultCheckerDto result = resultCheckerFacade.checkWhoWin(map);
        //then
        ResultOfRound expected = ResultOfRound.AIWon;
        assertThat(result.result().message).isEqualTo(expected.message);
        assertThat(result.message()).isEqualTo("Good");
    }

}