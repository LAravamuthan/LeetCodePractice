package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class GasStation {

    /**
     * Greedy algorithm.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(1).
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGain = 0, curGain = 0, answer = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGain += gas[i] - cost[i];
            curGain += gas[i] - cost[i];

            if (curGain < 0) {
                answer = i + 1;
                curGain = 0;
            }
        }

        return totalGain >= 0 ? answer : -1;
    }
}
