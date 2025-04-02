package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class UniquePathsII {

    /**
     * Dynamic programming bottom-up approach, lets try the most efficient approach itself.
     *
     * @time-complexity - O (n * m).
     * @space-complexity - O (1).
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1) return 0;

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        obstacleGrid[0][0] = 1;

        for (int c = 1; c < cols; c++){
            obstacleGrid[0][c] = obstacleGrid[0][c] == 1 ? 0 : obstacleGrid[0][c - 1];
        }

        for (int r = 1; r < rows; r++) {
            obstacleGrid[r][0] = obstacleGrid[r][0] == 1 ? 0 : obstacleGrid[r - 1][0];
            for (int c = 1; c < cols; c++) {
                obstacleGrid[r][c] = obstacleGrid[r][c] == 1 ? 0 : obstacleGrid[r - 1][c] + obstacleGrid[r][c - 1];
            }
        }

        return obstacleGrid[rows - 1][cols - 1];
    }

}
