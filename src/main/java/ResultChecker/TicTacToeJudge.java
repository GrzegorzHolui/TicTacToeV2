package ResultChecker;

import GameState.GameStateFacade;
import PositionReceiver.dto.PositionDto;

import java.util.Map;

public class TicTacToeJudge {
    GameStateFacade gameStateFacade;

    public TicTacToeJudge(GameStateFacade gameStateFacade) {
        this.gameStateFacade = gameStateFacade;
    }

    public ResultOfRound decideWhoWon() {
        Map<PositionDto, Character> mapTicTacToe = gameStateFacade.getCurrentTicTacToeMap();

        int rowToWin = gameStateFacade.getRowToWin();

        int length = gameStateFacade.getDimensionsOfTicTacToe();
        char[][] board = new char[length][length];

        char winner = ' ';


        for (PositionDto positionDto : mapTicTacToe.keySet()) {
            int x = positionDto.x();
            int y = positionDto.y();
            Character character = mapTicTacToe.get(positionDto);
            board[x][y] = character;
        }

        int n = board.length;

        // Check rows
        for (int i = 0; i < rowToWin; i++) {
            if (checkRow(board, i, rowToWin)) {
                winner = board[i][0];
                return whoWon(winner);
            }
        }

        // Check columns
        for (int j = 0; j < rowToWin; j++) {
            if (checkColumn(board, j, rowToWin)) {
                winner = board[0][j];
                return whoWon(winner);
            }
        }

        // Check diagonals
        if (checkDiagonal(board, rowToWin)) {
            winner = board[0][0];
            return whoWon(winner);
        }

        if (checkAntiDiagonal(board, rowToWin)) {
            winner = board[0][n - 1];
            return whoWon(winner);
        }

        // No winner
        return ResultOfRound.NoOneWon;
    }

    public ResultOfRound decideWhoWon( Map<PositionDto, Character> mapTicTacToe) {

        int rowToWin = gameStateFacade.getRowToWin();

        int length = gameStateFacade.getDimensionsOfTicTacToe();
        char[][] board = new char[length][length];

        char winner = ' ';


        for (PositionDto positionDto : mapTicTacToe.keySet()) {
            int x = positionDto.x();
            int y = positionDto.y();
            Character character = mapTicTacToe.get(positionDto);
            board[x][y] = character;
        }

        int n = board.length;

        // Check rows
        for (int i = 0; i < rowToWin; i++) {
            if (checkRow(board, i, rowToWin)) {
                winner = board[i][0];
                return whoWon(winner);
            }
        }

        // Check columns
        for (int j = 0; j < rowToWin; j++) {
            if (checkColumn(board, j, rowToWin)) {
                winner = board[0][j];
                return whoWon(winner);
            }
        }

        // Check diagonals
        if (checkDiagonal(board, rowToWin)) {
            winner = board[0][0];
            return whoWon(winner);
        }

        if (checkAntiDiagonal(board, rowToWin)) {
            winner = board[0][n - 1];
            return whoWon(winner);
        }

        // No winner
        return ResultOfRound.NoOneWon;
    }

    private static ResultOfRound whoWon(char winner) {
        if (winner == 'X') {
            return ResultOfRound.UserWon;
        } else if (winner == 'O') {
            return ResultOfRound.AIWon;
        }
        return ResultOfRound.NoOneWon;
    }

    private static boolean checkRow(char[][] board, int row, int rowToWin) {
        int n = board.length;

        char firstChar = board[row][0];

        if (firstChar == '-') {
            return false;
        }

        for (int j = 1; j < rowToWin; j++) {
            if (board[row][j] != firstChar) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkColumn(char[][] board, int col, int rowToWin) {
        int n = board.length;
        char firstChar = board[0][col];

        if (firstChar == '-') {
            return false;
        }

        for (int i = 1; i < rowToWin; i++) {
            if (board[i][col] != firstChar) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkDiagonal(char[][] board, int rowToWin) {
        int n = board.length;
        char firstChar = board[0][0];

        if (firstChar == '-') {
            return false;
        }

        for (int i = 1; i < rowToWin; i++) {
            if (board[i][i] != firstChar) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkAntiDiagonal(char[][] board, int rowToWin) {
        int n = board.length;
        char firstChar = board[0][n - 1];

        if (firstChar == '-') {
            return false;
        }

        for (int i = 1; i < rowToWin; i++) {
            if (board[i][n - 1 - i] != firstChar) {
                return false;
            }
        }
        return true;
    }
}
