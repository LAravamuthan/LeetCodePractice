package asu.edu.arav.amazon.interview.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/queue-reconstruction-by-height/
 */
public class QueueReconstructionbyHeight {

    /**
     * @algo - greedy
     * @time-complexity - O(nlogn)
     * @space-complexity - O(n)
     */

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length < 1) return people;

        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        for (int i = 0; i < people.length; i++) {
            people[i] = result.get(i);
        }
        return people;
    }
}
