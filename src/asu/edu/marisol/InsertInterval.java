package asu.edu.marisol;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class InsertInterval {

    /**
     * Basic linear search approach, O(n).
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> resultIntervals = new ArrayList<>();
        int n = intervals.length, i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            resultIntervals.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        resultIntervals.add(newInterval);

        while (i < n) {
            resultIntervals.add(intervals[i]);
            i++;
        }

        return resultIntervals.toArray(new int[resultIntervals.size()][]);

    }

    /**
     * Binary Search approach O(n).
     *
     * @time-complexity - O (n), if though we do binary Search, after finding the location to put the interval we
     * do linear time complexity merging of intervals.
     * @space-complexity - O (n).
     */
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) return intervals;

        int left = 0, right = intervals.length - 1;

        List<int []> initialResult = new ArrayList<>();

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (intervals[mid][0] < newInterval[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        for (int i = 0; i < left; i++) initialResult.add(intervals[i]);
        initialResult.add(newInterval);
        for (int i = left; i < intervals.length; i++) initialResult.add(intervals[i]);

        List<int []> finalResult = new ArrayList<>(); // mergedResult

        for (int [] interval : initialResult) {

            if (finalResult.isEmpty() || finalResult.get(finalResult.size() - 1)[1] < interval[0]) {
                finalResult.add(interval);
            } else {
                finalResult.get(finalResult.size() - 1)[1] = Math.max(finalResult.get(finalResult.size() - 1)[1], interval[1]);
            }
        }

        return finalResult.toArray(new int[finalResult.size()][]);
    }
}
