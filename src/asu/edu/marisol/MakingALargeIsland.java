package asu.edu.marisol;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MakingALargeIsland {

    /**
     * Let us see, coloring approach.
     *
     * TODO: Union find learning pls do.
     *
     * @time-complexity - O (M * N).
     * @space-complexity - O (M * N).
     */
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int nextIsLandId = 2;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    islandSizes.put(nextIsLandId, islandSize(grid, nextIsLandId, i, j));
                    nextIsLandId++;
                }
            }
        }

        if (islandSizes.size() == 0) return 1; // no island means single max flip.
        if (islandSizes.size() == 1) {
            return islandSizes.get(--nextIsLandId) == row * col ? row * col : islandSizes.get(nextIsLandId) + 1;
        }

        int maxIslandSizeAfterFlip = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    maxIslandSizeAfterFlip = Math.max(maxIslandSizeAfterFlip,
                            getCombinedIslandSize(grid, i, j, islandSizes));
                }
            }
        }

        return maxIslandSizeAfterFlip;
    }

    private int getCombinedIslandSize(int[][] grid, int row, int col, Map<Integer, Integer> islandSizes) {

        int rows = grid.length;
        int cols = grid[0].length;
        int [][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Set<Integer> isLands = new HashSet<>();

        for (int[] dir : dirs) {

            int x = row + dir[0];
            int y = col + dir[1];

            if (x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] > 1) isLands.add(grid[x][y]);

        }

        int maxIslandSize = 0;
        for (int island : isLands) {
           maxIslandSize += islandSizes.get(island);
        }

        return maxIslandSize;
    }

    private int islandSize(int[][] grid, int isLandId, int row, int col) {

        int rows = grid.length;
        int cols = grid[0].length;
        int [][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        grid[row][col] = isLandId;

        int size = 1;
        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == 1)
                size += islandSize(grid, isLandId, x, y);
        }

        return size;
    }

}
