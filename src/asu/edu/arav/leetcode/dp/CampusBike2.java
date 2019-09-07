package asu.edu.arav.leetcode.dp;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class CampusBike2 {

    public static int totalNumberOfWorkers = 0;
    public static int totalNumberOfBikes = 0;
    public static int ans = Integer.MAX_VALUE;
    public static int[][] workersG;
    public static int[][] bikesG;
    public static boolean[] usedWorker;
    public static boolean[] usedBike;

    public static int assignBikes2(int[][] workers, int[][] bikes) {
        totalNumberOfBikes = bikes.length;
        totalNumberOfWorkers = workers.length;
        usedWorker = new boolean[totalNumberOfWorkers];
        usedBike = new boolean[totalNumberOfBikes];
        workersG = workers;
        bikesG = bikes;
        usedWorker[0] = true;
        usedBike[0] = true;
        dfsOptimum(0, 0, 0);
        return ans;
    }

    public static void dfsOptimum(int workerNumber, int bikeNumber, int costSoFar) {

        int cost = distance(workersG[workerNumber], bikesG[bikeNumber]);
        if (workerNumber == totalNumberOfWorkers - 1) {
            ans = Math.min(ans, costSoFar + cost);
            return;
        }
        if (costSoFar > ans) {
            return;
        }
        for (int i = 0; i < totalNumberOfWorkers; i++) {
            for (int j = 0; j < totalNumberOfBikes; j++) {
                if (!usedBike[j] && !usedWorker[i]) {
                    usedBike[j] = true;
                    usedWorker[i] = true;
                    dfsOptimum(i, j, cost + costSoFar);
                    usedBike[j] = false;
                    usedWorker[i] = false;
                }
            }
        }

    }

    public static int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        System.out.println(assignBikes2(new int[][]{{0, 0}, {2, 1}}, new int[][]{{1, 2}, {3, 3}}));
    }


    public int assignBikes(int[][] workers, int[][] bikes) {
        int noOfWorkers = workers.length;
        int noOfBikes = bikes.length;

        int ans = Integer.MAX_VALUE;

        // 2-D array for CostToMap Mapping and using it later for DP formulation
        // State is mentioned in terms of setting the biting
        // 1 set in State representation being bike assigned
        // 0 being bike non assigned
        int[][] costToState = new int[noOfWorkers + 1][1 << noOfBikes];


        for (int[] costs : costToState) {
            Arrays.fill(costs, Integer.MAX_VALUE);
        }

        costToState[0][0] = 0;
        for (int i = 1; i <= noOfWorkers; i++) {
            for (int state = 1; state < (1 << noOfBikes); state++) {
                for (int bikeBit = 0; bikeBit < noOfBikes; bikeBit++) {
                    if ((state & (1 << bikeBit)) == 0) {
                        continue;
                    }
                    int previousState = state ^ (1 << bikeBit);
                    costToState[i][state] = Math.min(costToState[i][state],
                            costToState[i - 1][previousState] + dis(workers[i - 1], bikes[bikeBit]));
                    if (i == noOfWorkers) {
                        ans = Math.min(ans, costToState[i][state]);
                    }
                }
            }
        }
        return ans;
    }

    public int dis(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
