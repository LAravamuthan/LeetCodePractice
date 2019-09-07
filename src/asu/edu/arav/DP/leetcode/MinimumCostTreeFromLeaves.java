package asu.edu.arav.DP.leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class MinimumCostTreeFromLeaves {
    public static int mctFromLeafValues(int[] arr) {
        if(arr == null || arr.length ==0){
            return -1;
        }
        int [][] max = new int[arr.length][arr.length];
        int [][] minCost = new int[arr.length][arr.length];
        for(int i =0; i < arr.length; i++){
            int tmpMax = Integer.MIN_VALUE;
            for(int j=i; j < arr.length; j++){
                if(arr[j] > tmpMax){
                    tmpMax = arr[j];
                }
                max[i][j] = tmpMax;
            }
        }

        for(int size = 1; size < arr.length; size++){
            for(int left = 0; left + size < arr.length; left++){
                int right = left + size;
                minCost[left][right] = Integer.MAX_VALUE;
                if(size == 1){
                    minCost[left][right] = arr[left] * arr[right];
                }else{
                    for(int k = left; k < right; k++){
                        minCost[left][right] = Math.min(minCost[left][right], max[left][k] * max[k+1][right] +
                                minCost[left][k] + minCost[k+1][right]);
                    }
                }
            }
        }

        return minCost[0][arr.length-1];
    }

    public static void main(String[] args){
        mctFromLeafValues(new int[] {6,2,4});
    }
}
