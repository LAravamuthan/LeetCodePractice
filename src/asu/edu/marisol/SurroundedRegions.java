package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SurroundedRegions {

    /**
     * DFS approach.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (N).
     */
    public void solve(char[][] board) {
        this.nr = board.length;
        this.nc = board[0].length;

        Set<Integer> borders = new HashSet<>();

        for (int i = 0; i < nr; i++) {
            borders.add(i * nc);
            borders.add(i * nc + nc - 1);
        }

        for (int i = 0; i < nc; i++) {
            borders.add(i);
            borders.add((nr - 1) * nc + i);
        }

        for (int node : borders) {
            int r = node / nc;
            int c = node % nc;
            dfs(r, c, board);
        }

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'E')
                    board[i][j] = 'O';
            }
        }

    }

    private int nr;
    private int nc;

    private void dfs(int row, int col, char[][] board) {
        if (board[row][col] != 'O') return;

        board[row][col] = 'E';
        if (row + 1 < this.nr) dfs(row + 1, col, board);
        if (row - 1 >= 0) dfs(row - 1, col, board);
        if (col + 1 < this.nc) dfs(row, col + 1, board);
        if (col - 1 >= 0) dfs(row, col - 1, board);
    }

    /**
     * BFS approach.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (N).
     */
    public void solve2(char[][] board) {
        this.nr = board.length;
        this.nc = board[0].length;

        Set<Integer> borders = new HashSet<>();

        for (int i = 0; i < nr; i++) {
            borders.add(i * nc);
            borders.add(i * nc + nc - 1);
        }

        for (int i = 0; i < nc; i++) {
            borders.add(i);
            borders.add((nr - 1) * nc + i);
        }

        for (int node : borders) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                int n = queue.remove();
                int r = n / nc;
                int c = n % nc;
                if (board[r][c] != 'O') continue;
                board[r][c] = 'E';

                if (r + 1 < nr) queue.add((r + 1) * nc + c);
                if (r - 1 >= 0) queue.add((r - 1) * nc + c);
                if (c + 1 < nc) queue.add(r * nc + c + 1);
                if (c - 1 >= 0) queue.add(r * nc + c - 1);
            }
        }

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'E')
                    board[i][j] = 'O';
            }
        }

    }

}
