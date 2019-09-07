package asu.edu.arav.DP.leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CountCornersRect {

    public static int countCornerRectangles(int[][] grid) {
        int totalRects = 0;
        if (grid == null || grid.length == 0) {
            return totalRects;
        }
        int[][][] counts = new int[grid.length][grid[0].length][grid[0].length];
        boolean[][] roof = new boolean[grid[0].length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                for (int k = j + 1; k < grid[0].length; k++) {
                    if (grid[i][j] == 1 && grid[i][k] == 1) {
                        if (roof[j][k]) {
                            counts[i][j][k] = counts[i - 1][j][k] + 1;
                            totalRects += counts[i][j][k];
                        } else
                            roof[j][k] = true;
                    } else {
                        if(i > 0)
                            counts[i][j][k] = counts[i - 1][j][k];
                    }
                }
            }
        }
        return totalRects;
    }

    public static void main(String[] args) {
        int[][] in = {{1, 0, 1}, {0, 1, 1}, {1, 1, 1}, {1, 0, 1}};
        System.out.println(countCornerRectangles(in));
    }
}
