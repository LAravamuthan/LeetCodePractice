package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {

    // T - O(n)
    // cases to handle
    // -- if 1 present or not (if not 1 is the answer)
    // -- if n == 1 and 1 is present answer 2
    // -- if  element  == n  is not present  answer is n
    // -- if n is present 1 is also present and all the in between elements present
    // too then n + 1 is the answer
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        int contains = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                contains++;
                break;
            }
        }
        if (contains == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > n || nums[i] <= 0) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            if (a == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }


        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return n;
        }

        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        int[] a = {0, -1, 3, 1};
        fmp.firstMissingPositive(a);
    }
}
