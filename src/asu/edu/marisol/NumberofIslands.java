package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class NumberofIslands {

    /**
     * DFS approach.
     *
     * @time-complexity - O (N*M).
     * @space-complexity - O (NM).
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        this.grid = grid;
        int noIsLands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    noIsLands++;
                    dfs(i, j);
                }
            }
        }

        return noIsLands;
    }

    private char[][] grid;

    private void dfs(int row, int col) {

        int nr = grid.length;
        int nc = grid[0].length;

        if (row >= nr || col >= nc || row < 0 || col < 0 || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);

    }


    /**
     * DFS approach.
     *
     * @time-complexity - O (N*M).
     * @space-complexity - O (NM).
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int noIsLands = 0;
        int nr = grid.length;
        int nc = grid[0].length;

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    noIsLands++;
                    queue.offer(i * nc + j);
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int node = queue.remove();
                        int r = node / nc;
                        int c = node % nc;
                        if (r + 1 < nr && grid[r + 1][c] == '1') {
                            queue.offer((r + 1) * nc + c);
                            grid[r + 1][c] = '0';
                        }
                        if (c + 1 < nc && grid[r][c + 1] == '1') {
                            grid[r][c + 1] = '0';
                            queue.offer(r * nc + c + 1);
                        }
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            grid[r - 1][c] = '0';
                            queue.offer((r - 1) * nc + c);
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            grid[r][c - 1] = '0';
                            queue.offer(r * nc + c - 1);
                        }
                    }
                }
            }
        }

        return noIsLands;
    }

}
