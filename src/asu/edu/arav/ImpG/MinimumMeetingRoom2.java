package asu.edu.arav.ImpG;

import asu.edu.AravL.utility.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinimumMeetingRoom2 {

    public static int minMeetingRooms(int[][] intervals) {

        if(intervals.length == 0){
            return 0;
        }

        Interval[] intervalsList = new Interval[intervals.length];

        for(int i = 0; i < intervals.length; i ++){
            intervalsList[i] =  new Interval(intervals[i][0], intervals[i][1]);
        }

        Arrays.sort(intervalsList, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Integer> allot = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        allot.add(intervalsList[0].end);

        for(int i = 1; i < intervalsList.length; i++){
            if(intervalsList[i].start >= allot.peek()){
                allot.poll();
            }
            allot.add(intervalsList[i].end);
        }
        return allot.size();
    }

    public static void main(String [] args){

        int[][] min= new int[3][2];

        min[0][0] = 0;
        min[0][1] = 30;
        min[1][0] = 5;
        min[1][1] = 10;
        min[2][0] = 15;
        min[2][1] = 20;
        minMeetingRooms(min);
    }
}
