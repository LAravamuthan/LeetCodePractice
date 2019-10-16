package asu.edu.arav.amazon.interview.leetcode.module.SortingAndSearching;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/meeting-rooms-ii/
 */
public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        // if the interval is empty or null we need to just return 0 as the no. of room required
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        //Sort the intervals by their starting index
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // make a min heap of the finish times so as to add need interval that are not compatible with exsisting
        // interval finsh time
        PriorityQueue<Integer> allot = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for(int [] interval : intervals){
            // if first interval just insert the finishing time of the first interval
            if(allot.size() == 0){
                allot.add(interval[1]);
                continue;
            }
            // if  the start time of the current interval is greater than the the least finishing
            // time the remove the smallest finishing time as it is compatible with interval, thus it will
            // be removed the new finishing time will added to the min Heap
            if(allot.peek() <= interval[0]){
                allot.remove();
                allot.add(interval[1]);
            }else{// if the starting time of the current interval is  less the least finishing time then a new finishi
                //g time has to be added that is of itself
                allot.add(interval[1]);
            }
        }
        return allot.size();
    }

}
