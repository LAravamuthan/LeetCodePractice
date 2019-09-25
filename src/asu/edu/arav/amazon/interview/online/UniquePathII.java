package asu.edu.arav.amazon.interview.online;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int[][] pCM = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < pCM[0].length; i++) {
            if(obstacleGrid[0][i] != 1){
                pCM[0][i] = 1;
            }else{
                break;
            }

        }
        for (int i = 0; i < pCM.length; i++) {
            if(obstacleGrid[i][0] != 1){
                pCM[i][0] = 1;
            }else{
                break;
            }
        }
        for (int i = 1; i < pCM.length; i++) {
            for (int j = 1; j < pCM[0].length; j++) {
                if(obstacleGrid[i][j] == 1){
                    continue;
                }
                int left = obstacleGrid[i - 1][j] == 0 ? pCM[i - 1][j] : 0;
                int right = obstacleGrid[i][j - 1] == 0 ? pCM[i][j - 1] : 0;
                pCM[i][j] = left + right;
            }
        }
        return pCM[pCM.length - 1][pCM[0].length - 1];
    }
}
