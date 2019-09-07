package asu.edu.arav.leetcode.dp;

public class SuperEggProblem {


    /*
        This numberofFloors is an array to hold maximum possible floor we can work out with eggs being the index
        Wat we do here is from the awesome fact that
        numberofFloors[i]  = 1 +  numberofFloors[i](from previous steps) + numberofFloors[i-1](from previous steps)
        as the number of steps builds up, we monitor the value numberofFloors[K](where K - is maximum eggs available)
        for it cross or equal N(which max Floor avaiable)
         */
    public int superEggDrop(int K, int N) {


        int[] numberOfFloors = new int[K + 1];
        int maxSteps = 0;
        for (; numberOfFloors[K] < N; maxSteps++) {
            for (int i = K; i > 0; i--) {
                numberOfFloors[i] = 1 + numberOfFloors[i] + numberOfFloors[i - 1];
            }
        }
        return maxSteps;
    }

    public int[][] dfsResult;


    public int superEggDrop2(int K, int N) {
        dfsResult = new int[K + 1][N + 1];
        int steps = recursionDfs(K, N);
        return steps;
    }


    /* This dfs function finds the left sub tree and right tree and finds the point of
    intersection. The idea is to use Binary Search mechanism
    */
    public int recursionDfs(int i, int j) {
        if (i == 1) {
            return j;
        }
        if (j == 0) {
            return 0;
        }
        if (j == 1) {
            return 1;
        }
        if(dfsResult[i][j] > 0){
            return dfsResult[i][j];
        }
        int lo = 0;
        int hi = j;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int leftSubTreeSteps = recursionDfs(i - 1, mid - 1);
            int rightSubTreeSteps = recursionDfs(i, j - mid);
            if (leftSubTreeSteps < rightSubTreeSteps) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int result = 1 + Math.max(recursionDfs(i-1, lo-1), recursionDfs(i, j - lo));
        dfsResult[i][j] = result;
        return result;
    }
}
