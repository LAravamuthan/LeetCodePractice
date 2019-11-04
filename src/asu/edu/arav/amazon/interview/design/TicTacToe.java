package asu.edu.arav.amazon.interview.design;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/design-tic-tac-toe/
 */
public class TicTacToe {
    int rowSums[];
    int colSums[];
    int diagonalSum;
    int antiDiagonalSum;

    public TicTacToe(int n) {
        rowSums = new int[n];
        colSums = new int[n];
    }


    public int move(int row, int col, int player) {
        int size = rowSums.length;
        int moveValue = player == 1 ? 1 : -1;
        rowSums[row] += moveValue;
        colSums[col] += moveValue;
        if (row == col) {
            diagonalSum += moveValue;
        }
        if (row + col == size - 1) {
            antiDiagonalSum += moveValue;
        }
        if (Math.abs(rowSums[row]) == size || Math.abs(colSums[col]) == size || Math.abs(diagonalSum) == size
                || Math.abs(antiDiagonalSum) == size) {
            return player;
        }
        return 0;
    }

}
