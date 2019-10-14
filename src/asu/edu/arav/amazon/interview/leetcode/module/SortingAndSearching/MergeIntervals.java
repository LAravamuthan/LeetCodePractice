package asu.edu.arav.amazon.interview.leetcode.module.SortingAndSearching;

import asu.edu.aravl.utility.Interval;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {

        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> ansList = new ArrayList<Interval>();

        for (Interval intv : intervals) {
            int lastElementIdx = ansList.size() - 1;
            if (ansList.size() == 0 || ansList.get(lastElementIdx).end < intv.start) {
                ansList.add(intv);
            } else {
                ansList.get(lastElementIdx).end = intv.end;
            }
        }
        return ansList;
    }


    // array version instead of list
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            int lastIntervalIdx = ansList.size() - 1;
            if (lastIntervalIdx == -1 || ansList.get(lastIntervalIdx)[1] < interval[0]) {
                ansList.add(interval);
            } else {
                ansList.get(lastIntervalIdx)[1] = Math.max(interval[1], ansList.get(lastIntervalIdx)[1]);
            }
        }
        return ansList.toArray(new int[ansList.size()][]);
    }
}
