package ResultChecker;

import PositionReceiver.Position;
import PositionReceiver.dto.PositionDto;

import java.util.Map;

class TicTacToeJudge {

    public ResultOfRound decideWhoWon(Map<PositionDto, Character> mapTicTacToe) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                PositionDto position = new PositionDto(i, j);
                if (mapTicTacToe.containsKey(position)) {
                    board[i][j] = mapTicTacToe.get(position);
                } else {
                    board[i][j] = ' ';
                }
            }
        }

        // Sprawdź zwycięstwo w wierszach
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != ' ') {
                char winner = board[i][0];
                if (winner == 'X') {
                    return ResultOfRound.UserWon;
                } else if (winner == 'O') {
                    return ResultOfRound.AIWon;
                }
                return null;
            }
        }

        // Sprawdź zwycięstwo w kolumnach
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[0][j] == board[2][j] && board[0][j] != ' ') {
                char winner = board[0][j];
                if (winner == 'X') {
                    return ResultOfRound.UserWon;
                } else if (winner == 'O') {
                    return ResultOfRound.AIWon;
                }
                return null;
            }
        }

        // Sprawdź zwycięstwo na przekątnych
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ') {
            char winner = board[0][0];
            if (winner == 'X') {
                return ResultOfRound.UserWon;
            } else if (winner == 'O') {
                return ResultOfRound.AIWon;
            }
            return null;
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != ' ') {
            char winner = board[0][2];
            if (winner == 'X') {
                return ResultOfRound.UserWon;
            } else if (winner == 'O') {
                return ResultOfRound.AIWon;
            }
            return null;
        }

        // Jeśli nie ma zwycięzcy, zwróć znak 'D' (remis) lub ' ' (brak zwycięzcy)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return ResultOfRound.NoOneWon;
                }
            }
        }
        return ResultOfRound.Draw;
    }

}

