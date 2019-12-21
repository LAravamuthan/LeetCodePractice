package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int[] countArray = new int[3];
        for (int i = 0; i < nums.length; i++) {
            countArray[nums[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                nums[idx] = i;
                idx++;
                countArray[i]--;
            }
        }

    }


    public void sortColors1(int[] nums) {
        // left most idx to be placed for value 0
        int p0 = 0;

        // right most idx to be placed for value 2
        int p2 = nums.length - 1;

        // the current index to be processed
        int curr = 0;

        while (curr <= p2) {
            if (nums[curr] == 0) {
                int tmp = nums[p0];
                nums[p0] = nums[curr];
                nums[curr] = tmp;
                p0++;
                curr++;
            } else if (nums[curr] == 2) {
                int tmp = nums[p2];
                nums[p2] = nums[curr];
                nums[curr] = tmp;
                p2--;
            } else {
                curr++;
            }
        }

    }
}
