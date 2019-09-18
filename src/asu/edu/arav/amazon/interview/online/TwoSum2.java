package asu.edu.arav.amazon.interview.online;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int n = numbers.length - 1;
        int s = 0;
        while (s < n) {
            if (numbers[s] + numbers[n] > target) {
                n--;
            } else if (numbers[s] + numbers[n] < target) {
                s++;
            } else {
                return new int[]{s + 1, n + 1};
            }
        }
        return null;
    }
}
