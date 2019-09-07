package asu.edu.arav.DP.leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {

        int[][] ways = new int[m][n];

        for (int i = 0; i < n; i++) {
            ways[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            ways[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ways[i][j] = ways[i][j - 1] + ways[i - 1][j];
            }
        }
        return ways[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
}
