package asu.edu.arav.amazon.interview.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/meeting-rooms/
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length < 2){
            return true;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i =0; i < intervals.length; i++){
            if(i > 0){
                if(intervals[i][0] < intervals[i-1][1]){
                    return false;
                }
            }
        }
        return true;
    }
}
