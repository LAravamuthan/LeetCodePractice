package asu.edu.arav.amazon.interview.design;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class ShortestUnsortedContinuousSubarray {

    // O(n^2) better brute force
    // remember older bad one O(n^3)
    public int findUnsortedSubarray(int[] nums) {

        if (nums == null || nums.length < 2) {
            return 0;
        }
        // left boundary of sorted left portion
        int l = nums.length;
        // right boundary of sorted right portion
        int r = 0;

        // for each element find the element which is out of place w r t current element
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    l = Math.min(l, i);
                    r = Math.max(r, j);
                }
            }
        }
        return l < r ? r - l + 1 : 0;
    }

    // this is using sorting Onlgn
    public int findUnsortedSubarray1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        // left boundary of sorted left portion
        int l = nums.length;
        // right boundary of sorted right portion
        int r = 0;
        // in here we compare each element in sorted and unsorted arrays
        // ksep hold of the one which is out or posistion
        // when we find a out of position element it is candidate for both
        // left and right boundary hence we check whether it is or not
        // by max for r and min for l
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sortedNums[i]) {
                l = Math.min(l, i);
                r = Math.max(r, i);
            }
        }
        return l < r ? r - l + 1 : 0;
    }

    //this one is using stack same concept
    // uses the slope concept well
    public int findUnsortedSubarray2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        // in the this we keep on increasing the possible indexes till follows the pattern
        // of increasing slop of numbers the moment we fail in that
        // we find the out of place elements correct place
        // once we get that we minimise this process to get the left boundary
        int l = nums.length;
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                l = Math.min(l, st.pop());
            }
            st.push(i);
        }
        st.clear();
        // in the this we keep on decreasing the possible indexes till it follows the pattern
        // of decreasing slop of numbers the moment we fail in that
        // we find the out of place element's correct place
        // once we get that we maximise this process to get the right boundary
        int r = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                r = Math.max(r, st.pop());
            }
            st.push(i);
        }
        return l < r ? r - l + 1 : 0;
    }

    // let us try the solution without extra space and time complexity O(n)
    public int findUnsortedSubarray3(int[] nums) {

        
        return 0;
    }



}
