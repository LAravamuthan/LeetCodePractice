package asu.edu.marisol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CountSubarraysWhereMaxElementAppearsatLeastKTimes {

    /**
     * Sliding window which needs a better understanding, actually.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (1).
     */
    public long countSubarrays(int[] nums, int k) {
        long count = 0;
        int start = 0, maxElement = Arrays.stream(nums).max().getAsInt();
        int maxElementsInWindow = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == maxElement)
                maxElementsInWindow++;
            while (maxElementsInWindow == k) {
                if (nums[start] == maxElement)
                    maxElementsInWindow--;
                start++;
            }
            count += start;
        }

        return count;
    }

    /**
     * From the previous implementation, we saw that from the start index, we have that many subarrays.
     * Using the above idea/logic we can the store the indexes of maxElement, as the list of indexes grows, the last valid
     * index of maxElement which makes sure k number of maxElements occurred are the answer we are looking for cool.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (N).
     */
    public long countSubarrays2(int[] nums, int k) {
        long count = 0, maxElement = Arrays.stream(nums).max().getAsInt();
        List<Integer> maxElementIndexes = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxElement) maxElementIndexes.add(i);

            if (maxElementIndexes.size() >= k)
                count += maxElementIndexes.get(maxElementIndexes.size() - k) + 1;
        }

        return count;
    }

}
