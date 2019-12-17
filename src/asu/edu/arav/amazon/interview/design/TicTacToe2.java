package asu.edu.arav.amazon.interview.design;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class TicTacToe2 {

    int[] rowSum;
    int[] columnSum;
    int diagonalSum = 0;
    int antiDiagonalSum = 0;
    int size = 0;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe2(int n) {
        rowSum = new int[n];
        columnSum = new int[n];
        size = n;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int moveValue = player == 1 ? 1 : -1;
        rowSum[row] += moveValue;
        columnSum[col] += moveValue;
        if (row == col) {
            diagonalSum += moveValue;
        }
        if (row + col == size - 1) {
            antiDiagonalSum += moveValue;
        }
        return Math.abs(rowSum[row]) == size || Math.abs(columnSum[col]) == size || Math.abs(diagonalSum) == size ||
                Math.abs(antiDiagonalSum) == size ? player : 0;
    }
}
