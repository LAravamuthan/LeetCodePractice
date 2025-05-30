package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MapofHighestPeak {

    /**
     * This is mutli-BFS approach, hence the adjacent cells will never get more than one from the source.
     *
     * @time-complexity - O (M * N).
     * @space-complexity - O (M * N).
     */
    public int[][] highestPeak(int[][] isWater) {
        Set<Integer> sources = new HashSet<>();
        Queue<Integer> bfsQueue = new ArrayDeque<>();

        int m = isWater.length, n = isWater[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    isWater[i][j] = 0;
                    sources.add(i * n + j);
                    bfsQueue.offer(i * n + j);
                }
            }

        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            for (int level = 0; level < size; level++) {
                int node = bfsQueue.poll();
                int row = node / n, col = node % n;
                for (int[] dir : DIRS) {
                    int nrow = row + dir[0], ncol = col + dir[1];
                    int newNode = nrow * n + ncol;
                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !sources.contains(newNode)
                            && isWater[nrow][ncol] == 0) {
                        isWater[nrow][ncol] = isWater[row][col] + 1;
                        bfsQueue.offer(newNode);
                    }
                }
            }
        }

        return isWater;
    }

    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    /**
     * This is DP approach.
     *
     * @time-complexity - O (M * N).
     * @space-complexity - O (M * N).
     */
    public int[][] highestPeak2(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] tower = new int[m][n];
        int INVALID = m * n;
        for (int i = 0; i < m; i++)
            Arrays.fill(tower[i], INVALID);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1)
                    tower[i][j] = 0;
            }
        }

        // making value from element left and top.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int trow = i - 1;
                int minValue = INVALID;
                if (isValidCell(trow, j, m, n))
                    minValue = Math.min(minValue, tower[trow][j]);

                int lcol = j - 1;
                if (isValidCell(i, lcol, m, n))
                    minValue = Math.min(minValue, tower[i][lcol]);

                tower[i][j] = Math.min(tower[i][j], minValue + 1);

            }
        }


        // making value from element on right and bottom.
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int brow = i + 1;
                int minValue = INVALID;
                if (isValidCell(brow, j, m, n))
                    minValue = Math.min(minValue, tower[brow][j]);

                int rcol = j + 1;
                if (isValidCell(i, rcol, m, n))
                    minValue = Math.min(minValue, tower[i][rcol]);

                tower[i][j] = Math.min(tower[i][j], minValue + 1);
            }
        }

        return tower;
    }

    private boolean isValidCell(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

}
