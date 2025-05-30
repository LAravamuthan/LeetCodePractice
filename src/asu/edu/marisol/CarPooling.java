package asu.edu.marisol;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CarPooling {

    /**
     * Tree sort data structure, sort by the start and end location, basically sort by location thats it voila it works.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(1).
     */
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> locationTreeMap = new TreeMap<>();
        for (int[] trip : trips) {
            locationTreeMap.put(trip[1], locationTreeMap.getOrDefault(trip[1], 0) + trip[0]);
            locationTreeMap.put(trip[2], locationTreeMap.getOrDefault(trip[2], 0) - trip[0]);
        }

        int seats = 0;
        for (int people : locationTreeMap.values()) {
            seats += people;
            if (capacity < seats)
                return false;
        }

        return true;
    }


    /**
     * Bucket/Counting sort data.
     *
     * @time-complexity - O(max(n, 1001)).
     * @space-complexity - O(1001 ~ 1).
     */
    public boolean carPooling2(int[][] trips, int capacity) {
        int[] seats = new int[1001];

        for (int[] trip : trips) {
            seats[trip[1]] += trip[0];
            seats[trip[2]] -= trip[0];
        }

        int usedCapacity = 0;
        for (int i = 0; i < seats.length; i++) {
            usedCapacity += seats[i];
            if (capacity < usedCapacity)
                return false;
        }

        return true;
    }
}
