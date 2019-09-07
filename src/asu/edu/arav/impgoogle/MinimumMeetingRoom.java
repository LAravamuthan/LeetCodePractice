package asu.edu.arav.impgoogle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinimumMeetingRoom {
    public int minMeetingRooms(int[][] intervals) {
        List<Integer> strTimes = new ArrayList<Integer>();
        List<Integer> endTimes = new ArrayList<Integer>();
        for(int i = 0; i < intervals.length; i ++){
            strTimes.add(intervals[i][0]);
            endTimes.add(intervals[i][1]);
        }
        Collections.sort(strTimes);
        Collections.sort(endTimes);
        int roomsRequired = 0;
        int strTime = 0;
        int endTime = 0;
        while(strTime < strTimes.size()){

            if(strTimes.get(strTime) >= endTimes.get(endTime)){
                endTime++;
                roomsRequired--;
            }
            strTime++;
            roomsRequired++;
        }
        return roomsRequired;
    }
}
