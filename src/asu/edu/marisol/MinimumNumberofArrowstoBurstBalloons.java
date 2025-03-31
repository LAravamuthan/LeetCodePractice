package asu.edu.marisol;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinimumNumberofArrowstoBurstBalloons {

    /**
     * Greedy algorithm by sorting by start index this does not work, hence focus on de.
     *
     * @time-complexity - O(nlogn + n) - work it out pls
     * @space-complexity - O(N) - max recursion level will N depth long only.
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;

        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int arrows = 1;
        int curEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (curEnd < points[i][0]) {
                // meaning current balloon starts beyond the current end limit, needing a new arrow.
                arrows++;
                curEnd = points[i][1];
            }
        }

        return arrows;
    }

}
