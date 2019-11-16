package asu.edu.arav.amazon.interview.medium;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/bomb-enemy/
 */
public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int maxEnemeiesKilled = 0;
        int[][] countMatrix = new int[grid.length][grid[0].length];
        // iterate each row from left to right update count for
        // cell
        // similarily do it right to left too

        for (int i = 0; i < grid.length; i++) {
            int enemiesThatCanBeKilled = 0;// row wise value for each column
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'W') {
                    enemiesThatCanBeKilled = 0; // when ever we face Wall running to be
                    // initialsed
                }
                if (grid[i][j] == 'E') {
                    enemiesThatCanBeKilled++;
                }
                if (grid[i][j] == '0') {
                    countMatrix[i][j] += enemiesThatCanBeKilled;
                    maxEnemeiesKilled = Math.max(maxEnemeiesKilled, countMatrix[i][j]);
                }
            }
            enemiesThatCanBeKilled = 0;
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    enemiesThatCanBeKilled = 0; // when ever we face Wall running to be
                    // initialsed
                }
                if (grid[i][j] == 'E') {
                    enemiesThatCanBeKilled++;
                }
                if (grid[i][j] == '0') {
                    countMatrix[i][j] += enemiesThatCanBeKilled;
                    maxEnemeiesKilled = Math.max(maxEnemeiesKilled, countMatrix[i][j]);
                }
            }
        }


        // iterate each column from top to bottom then
        // bottom to top while doing so maintain count
        // of killed Enemies

        for (int j = 0; j < grid[0].length; j++) {
            int enemiesThatCanBeKilled = 0;// row wise value for each column
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 'W') {
                    enemiesThatCanBeKilled = 0; // when ever we face Wall running to be
                    // initialsed
                }
                if (grid[i][j] == 'E') {
                    enemiesThatCanBeKilled++;
                }
                if (grid[i][j] == '0') {
                    countMatrix[i][j] += enemiesThatCanBeKilled;
                    maxEnemeiesKilled = Math.max(maxEnemeiesKilled, countMatrix[i][j]);
                }
            }
            enemiesThatCanBeKilled = 0;
            for (int i = grid.length - 1; i >= 0; i--) {
                if (grid[i][j] == 'W') {
                    enemiesThatCanBeKilled = 0; // when ever we face Wall running to be
                    // initialsed
                }
                if (grid[i][j] == 'E') {
                    enemiesThatCanBeKilled++;
                }
                if (grid[i][j] == '0') {
                    countMatrix[i][j] += enemiesThatCanBeKilled;
                    maxEnemeiesKilled = Math.max(maxEnemeiesKilled, countMatrix[i][j]);
                }
            }
        }

        return maxEnemeiesKilled;
    }
}
