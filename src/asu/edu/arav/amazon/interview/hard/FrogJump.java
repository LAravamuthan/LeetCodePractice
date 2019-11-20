package asu.edu.arav.amazon.interview.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/frog-jump/
 */
public class FrogJump {

    // we have a map, now what do we do with that // O(n^2*3)
    public boolean canCross(int[] stones) {
        // track no. steps you took to reach there
        Map<Integer, Set<Integer>> locationToSteps = new HashMap<>();

        // this initialising is boiler plate I am just still thinking what to do nexr
        for (int i : stones) {
            locationToSteps.put(i, new HashSet<>());
        }
        locationToSteps.get(0).add(0);
        // from 1nd location itself start reaching new places in various ways
        // For each step we reached at particular location
        // try various other values
        for (int i = 0; i < stones.length; i++) {
            for (int k : locationToSteps.get(stones[i])) {
                for (int steps = k - 1; steps <= k + 1; steps++) {
                    if (steps > 0 && locationToSteps.containsKey(stones[i] + steps)) {
                        locationToSteps.get(stones[i] + steps).add(steps);
                    }
                }
            }
        }
        return locationToSteps.get(stones[stones.length - 1]).size() > 0;
    }

}
