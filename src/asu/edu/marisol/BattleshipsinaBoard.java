package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BattleshipsinaBoard {

    /**
     * Count with DFS.
     *
     * @time-complexity - O (m * n).
     * @space-complexity - O (m * n).
     */
    public int countBattleships(char[][] board) {
        this.battleShips = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    battleShips++;
                    dfs(i, j, board);
                }
            }
        }

        return battleShips;
    }

    private int battleShips;

    private int[][] DIRS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(int row, int col, char[][] board) {
        board[row][col] = '.';

        for (int[] dir : DIRS) {
            int nrow = row + dir[0], ncol = col + dir[1];
            if (nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board[0].length && board[nrow][ncol] == 'X') {
                dfs(nrow, ncol, board);
            }
        }
    }

    /**
     * Since tanks are in straight lines we check the previous row or col for tank presence if yes it is part of previous ship
     * or it is a start of new ship.
     *
     * @time-complexity - O (m * n).
     * @space-complexity - O (m * n).
     */
    public int countBattleships1(char[][] board) {
        int m = board.length, n = board[0].length;

        int battleShips = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (i - 1 >= 0 && board[i - 1][j] == 'X') continue;
                if (j - 1 >= 0 && board[i][j - 1] == 'X') continue;
                battleShips++;
            }
        }

        return battleShips;
    }

}
