package asu.edu.marisol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MeetingRoomsII {

    /**
     * PQ style and sort by start time.
     *
     * @time-complexity - O (NlogN).
     * @space-complexity - O (N).
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        PriorityQueue<Integer> rooms = new PriorityQueue<>(intervals.length, Comparator.comparingInt(a -> a));
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        rooms.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= rooms.peek()) rooms.poll();
            rooms.add(intervals[i][1]);
        }

        return rooms.size();
    }

    /**
     * sorting both and end and start times and treating them individually lets this how this goes.
     *
     * @time-complexity - O (NlogN).
     * @space-complexity - O (N).
     */
    public int minMeetingRooms2(int[][] intervals) {
        int rooms = 0, startIdx = 0, endIdx = 0;
        Integer[] start =  new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start, Comparator.comparingInt(a -> a));
        Arrays.sort(end, Comparator.comparingInt(a -> a));

        while(startIdx < intervals.length) {
            if (start[startIdx] >= end[endIdx]) {
                rooms--;
                endIdx++;
            }

            rooms++;
            startIdx++;
        }

        return rooms;
    }

}
