

public class TicTacToe {

    private static final char EMPTY = '-';
    private static final char PLAYER = 'X';
    private static final char COMPUTER = 'O';

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'O'},
                {'X', 'O', 'O', 'O'},
                {'X', 'O', 'X', 'O'},
                {'X', 'O', 'O', 'X'}
        };

        int size = 4; // Size of the board
        int numToWin = 4; // Number of characters in a row needed to win

        int[] bestMove = getBestMove(board, size, numToWin);
        System.out.println("Best move: (" + bestMove[0] + ", " + bestMove[1] + ")");
    }

    public static int[] getBestMove(char[][] board, int size, int numToWin) {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = new int[2];

        if (isBoardFull(board, size) && evaluate(board, size, numToWin) == -10) {
            bestMove[0] = -1; // Indicate that the game is already won by the opponent
            bestMove[1] = -1;
            return bestMove;
        }

        if (evaluate(board, size, numToWin) == 10) {
            bestMove[0] = -1; // Indicate that the game is already won by the opponent
            bestMove[1] = -1;
            return bestMove;
        }
//        else if (evaluate(board, size, numToWin) == -10) {
//            bestMove[0] = -1; // Indicate that the game is already won by the opponent
//            bestMove[1] = -1;
//            return bestMove;
//        }


        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == EMPTY) {
                    board[row][col] = COMPUTER;
                    int score = minimax(board, size, numToWin, 0, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    board[row][col] = EMPTY;

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = row;
                        bestMove[1] = col;
                    }
                }
            }
        }

        return bestMove;
    }

    public static int minimax(char[][] board, int size, int numToWin, int depth, boolean isMaximizingPlayer, int alpha, int beta) {
        int score = evaluate(board, size, numToWin);

        if (score == 10 || score == -10)
            return score - depth;

        if (isBoardFull(board, size))
            return 0;

        if (isMaximizingPlayer) {
            int maxScore = Integer.MIN_VALUE;

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (board[row][col] == EMPTY) {
                        board[row][col] = COMPUTER;
                        int currentScore = minimax(board, size, numToWin, depth + 1, false, alpha, beta);
                        board[row][col] = EMPTY;

                        maxScore = Math.max(maxScore, currentScore);
                        alpha = Math.max(alpha, maxScore);

                        if (beta <= alpha)
                            break;
                    }
                }
            }

            return maxScore;
        } else {
            int minScore = Integer.MAX_VALUE;

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (board[row][col] == EMPTY) {
                        board[row][col] = PLAYER;
                        int currentScore = minimax(board, size, numToWin, depth + 1, true, alpha, beta);
                        board[row][col] = EMPTY;

                        minScore = Math.min(minScore, currentScore);
                        beta = Math.min(beta, minScore);

                        if (beta <= alpha)
                            break;
                    }
                }
            }

            return minScore;
        }
    }


    public static int evaluate(char[][] board, int size, int numToWin) {
        // Check rows
        for (int row = 0; row < size; row++) {
            for (int col = 0; col <= size - numToWin; col++) {
                boolean winningRow = true;
                for (int i = 0; i < numToWin; i++) {
                    if (board[row][col + i] != board[row][col] || board[row][col] == EMPTY) {
                        winningRow = false;
                        break;
                    }
                }
                if (winningRow) {
                    return board[row][col] == COMPUTER ? 10 : -10;
                }
            }
        }

        // Check columns
        for (int col = 0; col < size; col++) {
            for (int row = 0; row <= size - numToWin; row++) {
                boolean winningColumn = true;
                for (int i = 0; i < numToWin; i++) {
                    if (board[row + i][col] != board[row][col] || board[row][col] == EMPTY) {
                        winningColumn = false;
                        break;
                    }
                }
                if (winningColumn) {
                    return board[row][col] == COMPUTER ? 10 : -10;
                }
            }
        }

        // Check diagonals
        for (int row = 0; row <= size - numToWin; row++) {
            for (int col = 0; col <= size - numToWin; col++) {
                boolean winningDiagonal = true;
                for (int i = 0; i < numToWin; i++) {
                    if (board[row + i][col + i] != board[row][col] || board[row][col] == EMPTY) {
                        winningDiagonal = false;
                        break;
                    }
                }
                if (winningDiagonal) {
                    return board[row][col] == COMPUTER ? 10 : -10;
                }
            }
        }

        // Check anti-diagonals
        for (int row = numToWin - 1; row < size; row++) {
            for (int col = 0; col <= size - numToWin; col++) {
                boolean winningAntiDiagonal = true;
                for (int i = 0; i < numToWin; i++) {
                    if (board[row - i][col + i] != board[row][col] || board[row][col] == EMPTY) {
                        winningAntiDiagonal = false;
                        break;
                    }
                }
                if (winningAntiDiagonal) {
                    return board[row][col] == COMPUTER ? 10 : -10;
                }
            }
        }

        return 0;
    }

    public static boolean isBoardFull(char[][] board, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == EMPTY)
                    return false;
            }
        }

        return true;
    }
}
