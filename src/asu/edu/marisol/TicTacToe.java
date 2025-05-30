package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class TicTacToe {

    /**
     * Design effort
     *
     * @time-complexity - O(1).
     * @space-complexity - O(1).
     */
    public TicTacToe(int n) {
        this.n = n;
        this.diagonal = 0;
        this.antidiagonal = 0;
        this.rows = new int[n];
        this.cols = new int[n];
    }


    /**
     * Design effort.
     *
     * @time-complexity - O(1).
     * @space-complexity - O(n).
     */
    public int move(int row, int col, int player) {
        int sign = player == 1 ? 1 : -1;
        rows[row] += sign;
        cols[col] += sign;
        if (row == col) diagonal += sign;
        if (row + col == n - 1) antidiagonal += sign;

        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal) == n || Math.abs(antidiagonal) == n)
            return player;
        else return 0;
    }

    private int n, diagonal, antidiagonal;
    private int[] rows, cols;

}
