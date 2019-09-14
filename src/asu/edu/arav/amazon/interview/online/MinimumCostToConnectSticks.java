package asu.edu.arav.amazon.interview.online;

import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        if(sticks == null || sticks.length == 0){
            return 0;
        }
        if(sticks.length == 1){
            return sticks[0];
        }
        PriorityQueue<Integer> currentlyUnmergedSticks = new PriorityQueue<Integer>();
        for(int i = 0; i < sticks.length; i++){
            currentlyUnmergedSticks.offer(sticks[i]);
        }
        int cost = 0;
        while (currentlyUnmergedSticks.size() > 1){
            int tempSum = currentlyUnmergedSticks.poll() + currentlyUnmergedSticks.poll();
            cost += tempSum;
            currentlyUnmergedSticks.offer(tempSum);
        }
        return cost;
    }
}
