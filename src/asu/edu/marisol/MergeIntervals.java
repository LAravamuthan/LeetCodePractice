package asu.edu.marisol;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MergeIntervals {

    /**
     * Sort by the start idx of the interval.
     *
     * @time-complexity - O (nlogn), n-> no. of intervals.
     * @space-complexity - O (n) - height of the tree.
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> mergedIntervals = new LinkedList<>();
        for (int[] interval : intervals) {
            if (mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < interval[0])
                mergedIntervals.add(interval);
            mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], interval[1]);
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
