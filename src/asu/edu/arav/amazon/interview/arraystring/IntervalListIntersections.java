package asu.edu.arav.amazon.interview.arraystring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/interval-list-intersections/
 */
public class IntervalListIntersections {

    /**
     * @algo - Arrays 2 Two pointer I guess
     * @time-complexity - O(n + m)
     * @space-complexity - O(n + m)
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        List<int[]> listOfIntervals = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int startIdx = Math.max(A[i][0], B[j][0]);
            int endIdx = Math.min(A[i][1], B[j][1]);
            if (startIdx <= endIdx) {
                int[] interval = new int[]{startIdx, endIdx};
                listOfIntervals.add(interval);
            }
            if (A[i][1] == B[j][1]) {
                i++;
                j++;
            } else if (A[i][1] > B[j][1]) {
                j++;
            } else {
                i++;
            }
        }
        int[][] ans = new int[listOfIntervals.size()][2];
        for (int k = 0; k < listOfIntervals.size(); k++) {
            ans[k] = listOfIntervals.get(k);
        }
        return listOfIntervals.toArray(new int[listOfIntervals.size()][2]);
    }
}
