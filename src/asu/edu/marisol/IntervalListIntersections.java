package asu.edu.marisol;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class IntervalListIntersections {

    /**
     * Merge intervals approach.
     *
     * @time-complexity - O (m + n).
     * @space-complexity - O (m + n).
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> answer = new ArrayList<>();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);

            if (lo <= hi) answer.add(new int[] {lo, hi});

            if (firstList[i][1] < secondList[j][1]) i++;
            else j++;
        }

        return answer.toArray(new int[answer.size()][]);
    }

}
