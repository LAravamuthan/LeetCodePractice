package asu.edu.arav.leetcode.competition;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class GoldMine {

    static int [][] gridG;

    public static int getMaximumGold(int[][] grid) {
        if(grid == null|| grid.length==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        gridG = grid;
        for(int i = 0; i < gridG.length; i++){
            for(int j =0; j < gridG[0].length; j++){
                if(gridG[i][j] == 0){
                    continue;
                }
                int reward = dfs(i, j, 0, gridG.length, gridG[0].length);
                max = Math.max(reward, max);
            }
        }
        return max;
    }

    public static int dfs(int i, int j, int reward, int m, int n){
        if(i < 0 || i > m-1 || j < 0 || j > n-1 ){
            return reward;
        }
        if(gridG[i][j] == 0){
            return reward;
        }
        int maxReward = reward + gridG[i][j];
        int temp = maxReward;
        int temp2 = gridG[i][j];
        gridG[i][j] = 0;
        int one1 = dfs(i-1, j, temp, m, n);
        maxReward = Math.max(maxReward, one1);
        int one2 = dfs(i+1, j, temp, m, n);
        maxReward = Math.max(maxReward, one2);
        int one3 = dfs(i, j-1, temp, m, n);
        maxReward =Math.max(maxReward, one3);
        int one4 = dfs(i, j+1, temp, m, n);
        maxReward = Math.max(maxReward, one4);
        gridG[i][j] = temp2;
        return maxReward;
    }

    public static void main(String [] args){
        int [][] a =  new int[][]{{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(getMaximumGold(a));
    }

}
