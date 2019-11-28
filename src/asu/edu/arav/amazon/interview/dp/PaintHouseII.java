package asu.edu.arav.amazon.interview.dp;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/paint-house-ii/
 */
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;

        int prevMin = 0, prevMinIdx = -1, prevSecMin = 0;

        for(int i =0; i < n; i++){
            int min = Integer.MAX_VALUE, minIdx = -1, secMin = Integer.MAX_VALUE;
            for(int j=0; j < k; j++){
                int cVal = costs[i][j] +  (j == prevMinIdx ? prevSecMin : prevMin);
                if(cVal < min){
                    secMin = min;
                    minIdx = j;
                    min = cVal;
                }else if (cVal < secMin){
                    secMin = cVal;
                }
            }
            prevMin = min;
            prevMinIdx = minIdx;
            prevSecMin = secMin;
        }
        return prevMin;
    }
}
