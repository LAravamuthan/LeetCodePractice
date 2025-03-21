package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class GameofLife {

    /*
    Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     */

    /**
     * Traversal of whole 2D array.
     *
     * @time-complexity - O (M * N) length * breadth
     * @space-complexity - O (1)
     */
    // TODO: Study the graph approach.
    public void gameOfLife(int[][] board) {

        int [] dirs = { 1, 0, -1 };
        int m = board.length;
        int n = board[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int liveNeighors = 0;
                for (int i : dirs) {
                    for (int j : dirs) {
                        if (!(i == 0 && j == 0)) {
                            int nr = row + i;
                            int nc = col + j;
                            if (nr >= 0 && nc >= 0 && nr < m && nc < n && Math.abs(board[nr][nc]) == 1)
                                liveNeighors++;
                        }
                    }
                }
                if (board[row][col] == 1 && (liveNeighors < 2 || liveNeighors > 3))
                    board[row][col] = -1;
                if (board[row][col] == 0 && liveNeighors == 3)
                    board[row][col] = 2;
            }
        }

        for (int row = 0; row < m; row++){
            for (int col = 0; col < n; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}
