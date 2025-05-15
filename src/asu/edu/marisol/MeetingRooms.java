package asu.edu.marisol;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MeetingRooms {

    /**
     * Sorting by start time of the interval.
     *
     * @time-complexity - O (nlogn).
     * @space-complexity - O (1).
     */
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int lastEndTime = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEndTime) return false;
            lastEndTime = intervals[i][1];
        }

        return true;
    }

    /**
     * Sorting by start time of the interval, further optimized
     *
     * @time-complexity - O (nlogn).
     * @space-complexity - O (1).
     */
    public boolean canAttendMeetings2(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length - 1; i++)
            if (intervals[i][1] > intervals[i + 1][0]) return false;

        return true;
    }

}
