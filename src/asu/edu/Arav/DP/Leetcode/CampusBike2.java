package asu.edu.Arav.DP.Leetcode;

import java.util.Arrays;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class CampusBike2 {

    public int assignBikes(int[][] workers, int[][] bikes) {
        int noOfWorkers = workers.length;
        int noOfBikes = bikes.length;

        int ans = Integer.MAX_VALUE;

        // 2-D array for CostToMap Mapping and using it later for DP formulation
        // State is mentioned in terms of setting the biting
        // 1 set in State representation being bike assigned
        // 0 being bike non assigned
        int [][] costToState = new int[noOfWorkers+1][1 << noOfBikes];


        for(int [] costs : costToState){
            Arrays.fill(costs, Integer.MAX_VALUE);
        }

        costToState[0][0] = 0;
        for(int i = 1; i <=noOfWorkers; i ++){
            for(int state = 1; state < (1 << noOfBikes); state++){
                for(int bikeBit = 0; bikeBit < noOfBikes; bikeBit++){
                    if((state & (1 << bikeBit)) == 0){
                        continue;
                    }
                    int previousState = state ^ (1<<bikeBit);
                    costToState[i][state] = Math.min(costToState[i][state],
                            costToState[i-1][previousState] + dis(workers[i-1], bikes[bikeBit]));
                    if(i == noOfWorkers){
                        ans = Math.min(ans, costToState[i][state]);
                    }
                }
            }
        }
        return ans;
    }

    public int dis(int [] p1, int [] p2){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
