package asu.edu.arav.amazon.interview.greedy;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/gas-station/
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }

        // we calculate whether we can start from a particular starting point or not
        // if not we move forward, but at the same time we keep track of the running
        // difference needed gas and the available gas in the gas stations
        // this has to be positive for a tour to be positive
        int total_cost = 0; // testing whether tour possible or not
        int cur_cost = 0;// to be used for testing each gas station as the starting point
        int starting_station = 0;
        for (int i = 0; i < gas.length; i++) {
            total_cost += gas[i] - cost[i];
            cur_cost += gas[i] - cost[i];
            if (cur_cost < 0) {
                starting_station = i + 1;
                cur_cost = 0;// for the next station we start again
                // even if the it was not negative previously but became negative here
                // the current station obviously of no use , hence the start from the next one
            }
        }

        return total_cost >= 0 ? starting_station : -1;
    }
}
