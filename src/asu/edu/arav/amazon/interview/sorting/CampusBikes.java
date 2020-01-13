package asu.edu.arav.amazon.interview.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/campus-bikes/
 */
public class CampusBikes {
    /**
     * @algo Counting or Bucket Sort approach
     * @time-complexity O(mn) where m -- no. of bikes and n -- no. of workers
     * @space-complexity O(mn) where m -- no. of bikes and n -- no. of workers
     */


    public int[] assignBikes(int[][] workers, int[][] bikes) {
        if (workers == null || bikes == null || workers.length == 0 || bikes.length == 0) {
            return new int[0];
        }
        /* Here we need to sort the all the pairs in order of the manhattan distance
         * followed worker and bike index, since the manhattan distance has the maximum
         * value of 2000*/

        List<int[]>[] distances = new List[2001];
        int[] workersAssigned = new int[workers.length];
        int[] bikesAssigned = new int[workers.length];
        Arrays.fill(workersAssigned, -1);
        Arrays.fill(bikesAssigned, -1);

        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = Math.abs(workers[i][0] - bikes[i][0]) + Math.abs(workers[i][1] - bikes[i][1]);
                if (distances[distance] == null) {
                    distances[distance] = new ArrayList<>();
                }
                distances[distance].add(new int[]{i, j});
            }
        }

        int assigned = 0;

        for (int i = 0; i < distances.length && assigned < workers.length; i++) {
            if (distances[i] == null) {
                continue;
            } else {
                for (int[] pair : distances[i]) {
                    if (workersAssigned[pair[0]] == -1 && bikesAssigned[pair[1]] == -1) {
                        assigned++;
                        workersAssigned[pair[0]] = pair[1];
                        bikesAssigned[pair[1]] = pair[0];
                    }
                }
            }
        }
        return workersAssigned;
    }
}
