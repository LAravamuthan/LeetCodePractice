package asu.edu.arav.amazon.interview.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/prison-cells-after-n-days/
 */
public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) {
            return cells;
        }

        // this integer will show the current state of the cells
        // this question is designed to work with 8 bit integer I guess
        int state = 0;
        // setting the value of the cells insied a integer
        // we use left shift for the same , to reach that bit
        // if its set in cell we try to set it in state too
        // using the bit wise XOR as the state in itself will set ot value to
        // 0, lets see how it goes.

        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == 1) {
                state ^= 1 << i;
            }
        }

        Map<Integer, Integer> statesMap = new HashMap<Integer, Integer>();

        while (N > 0) {

            if (statesMap.containsKey(state)) {
                N %= statesMap.get(state) - N; // statesMap.get(state) (the value of N when it was seen before) - N
            }

            statesMap.put(state, N);
            // this if condition is very important as we all know that
            // the cycle % operation might make the value of N == 0, for which we should not find the next day
            if(N >= 1){
                state = getNextState(state);
                N--;
            }
        }

        return intToCellArray(state);
    }


    // this will return the next state using the current state
    public int getNextState(int state) {
        int nextState = 0;

        // left and right corners will not set ever so ignore them
        // if the adjacent cells are same then the current cell will be set
        // we use right shift to bring the bit to last bit and use bit wise and with 1
        for (int i = 1; i < 7; i++) {
            if (((state >> (i - 1)) & 1) == ((state >> (i + 1)) & 1)) {
                nextState ^= 1 << i;
            }
        }

        return nextState;
    }

    // convert the integer value to cell array
    public int[] intToCellArray(int state) {
        int[] cells = new int[8];
        for (int i = 0; i < cells.length; i++) {
            if (((state >> i) & 1) == 1) {
                cells[i] = 1;
            }
        }
        return cells;
    }


}
