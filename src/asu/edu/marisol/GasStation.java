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

    /**
     * Sliding window.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(1).
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int fuel = 0, s = 0, e = 0;
        int size = gas.length;

        while (s < size) {
            int costToMove = gas[e % size] - cost[e % size];
            if (fuel + costToMove >= 0) {
                if (e - s + 1 == size) return s;
                fuel += costToMove;
                e++;
            } else {
                if (s < e) fuel -= gas[s] - cost[s];
                if (s == e) e++;
                s++;
            }
        }
        return -1;
    }
}
