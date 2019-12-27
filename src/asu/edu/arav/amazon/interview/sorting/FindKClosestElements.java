package asu.edu.arav.amazon.interview.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-k-closest-elements/
 */
public class FindKClosestElements {


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> nums = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(nums, (a, b) -> a == b ? a - b : Math.abs(a - x) - Math.abs(b - x));
        nums = nums.subList(0, k);
        Collections.sort(nums);
        return nums;
    }


    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> nums = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int size = arr.length;
        if (x < arr[0]) {
            return nums.subList(0, k);
        } else if (x > arr[size - 1]) {
            return nums.subList(size - k, size);
        }

        int idx = Collections.binarySearch(nums, x);
        if (idx < 0) {
            idx = -idx - 1;
        }

        int lo = Math.max(0, idx - k);
        int high = Math.min(size - 1, idx + k - 1);
        while (high - lo + 1 > k) {
            if (x - arr[lo] > arr[high] - x) {
                lo++;
            } else {
                high--;
            }
        }

        return nums.subList(lo, high + 1);
    }

}
