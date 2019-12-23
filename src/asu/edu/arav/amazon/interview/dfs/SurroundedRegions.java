package asu.edu.arav.amazon.interview.dfs;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {

    boolean[][] visited = null;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        this.visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                // TO DFS to mark all the connected elements Visited
                dfs(i, 0, board);
            }
            if (board[i][board[0].length - 1] == 'O') {
                // TO DFS to mark all the connected elements Visited
                dfs(i, board[0].length - 1, board);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                // TO DFS to mark all the connected elements Visited
                dfs(0, i, board);
            }
            if (board[board.length - 1][i] == 'O') {
                // TO DFS to mark all the connected elements Visited
                dfs(board.length - 1, i, board);
            }
        }
        // mark the unvistied the 'O' to 'X'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }


    public void dfs(int r, int c, char[][] board) {
        if (r < 0 || r > board.length - 1 || c < 0 || c > board[0].length - 1 || visited[r][c] ||  board[r][c] != 'O') {
            return;
        }
        visited[r][c] = true;
        dfs(r + 1, c, board);
        dfs(r - 1, c, board);
        dfs(r, c + 1, board);
        dfs(r, c - 1, board);
    }
}
