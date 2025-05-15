package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ShortestDistancefromAllBuildings {

    /**
     * Set rows and cols to zero based on initial setting of row and col heads.
     *
     * @time-complexity - O (M^2 * N^2).
     * @space-complexity - O (M * N).
     */
    public int shortestDistance(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int totalHouses = 0, minDist = Integer.MAX_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) totalHouses++;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0)
                    minDist = Math.min(minDist, bfsSearchForBuildings(i, j, grid, totalHouses));
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int bfsSearchForBuildings(int row, int col, int[][] grid, int totalHouses) {
        int housesFound = 0, distance = 0;
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {row, col});
        visited[row][col] = true;

        int steps = 0;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i++) {
                int [] node = q.poll();
                row = node[0];
                col = node[1];

                if (grid[row][col] == 1) {
                    housesFound++;
                    distance += steps;
                    continue;
                }

                for (int[] dir : DIRS) {
                    int nrow = row + dir[0];
                    int ncol = col + dir[1];

                    if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols) {
                        if (!visited[nrow][ncol] && grid[nrow][ncol] != 2) {
                            q.offer(new int[] {nrow, ncol});
                            visited[nrow][ncol] = true;
                        }
                    }
                }
            }
            steps++;
        }

        if (housesFound != totalHouses) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 0 && visited[i][j])
                        grid[i][j] = 2;
                }
            }
        }

        return housesFound != totalHouses ? Integer.MAX_VALUE : distance;
    }


    /**
     * Set rows and cols to zero based on initial setting of row and col heads.
     *
     * @time-complexity - O (M^2 * N^2).
     * @space-complexity - O (M * N).
     */
    public int shortestDistance2(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int minDist = Integer.MAX_VALUE, curEmployPlot = 0;
        int[][] dist = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    minDist = Integer.MAX_VALUE;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[] {i, j});
                    int steps = 0;
                    while (!q.isEmpty()) {
                        steps++;
                        for (int k = q.size(); k > 0; k--) {
                            int[] node = q.poll();
                            int row = node[0], col = node[1];

                            for (int [] dir : DIRS) {
                                int nrow = row + dir[0];
                                int ncol = col + dir[1];
                                if (nrow >= 0 && nrow < rows && ncol >=0 && ncol < cols && grid[nrow][ncol] == curEmployPlot) {
                                    grid[nrow][ncol]--;
                                    dist[nrow][ncol] += steps;
                                    minDist = Math.min(minDist, dist[nrow][ncol]);
                                    q.offer(new int[] {nrow, ncol});
                                }
                            }
                        }

                    }
                    curEmployPlot--;
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
