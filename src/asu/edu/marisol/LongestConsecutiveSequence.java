package asu.edu.marisol;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class LongestConsecutiveSequence {

    /**
     * Simple hashMap solution.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (h).
     */
    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        int bestStreak = 0;
        for (int num : nums) numSet.add(num);
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int curNum = num;
                int currentStreak = 1;
                while (numSet.contains(curNum + 1)) {
                    curNum += 1;
                    currentStreak += 1;
                }
                bestStreak = Math.max(currentStreak, bestStreak);
            }
        }

        return bestStreak;

    }


}
