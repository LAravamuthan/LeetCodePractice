package asu.edu.arav.amazon.interview.leetcode.module.SortingAndSearching;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0.0;
        }
        // if nums1 == null the median is from num2 only
        if (nums1 == null) {
            if (nums2.length % 2 == 1) {
                return (double) nums2[nums2.length / 2];
            } else {
                return (double) (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2;
            }
        }
        // if nums2 == null the median is from num1 only
        if (nums2 == null) {
            if (nums1.length % 2 == 1) {
                return (double) nums1[nums1.length / 2];
            } else {
                return (double) (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2;
            }
        }
        // get the smallest of the two and assign it to num1
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int n = nums1.length, m = nums2.length;

        // min and max number of elements taken from nums1 and nums2
        int minEle = 0, maxEle = n, median = 0, nums1Ele = 0, nums2Ele = 0;

        // binary search type condition
        while (minEle <= maxEle) {
            // choose the half of max and min possible elements from nums1
            nums1Ele = (minEle + maxEle) / 2;
            // this is the total elements possible in the left half - total elements from nums1
            nums2Ele = (n + m + 1) / 2 - nums1Ele;
            // if the last element from nums1 is greater than the element after the
            // last element chosen from nums2 than decrement the nums1 max contribution
            // of nums1 to be 1 less than nums1Ele
            if (nums1Ele > 0 && nums2Ele < m && nums1[nums1Ele - 1] > nums2[nums2Ele]) {
                maxEle = nums1Ele - 1;
            }
            // if the last element from nums2 is greater than the element after the
            // last element chosen from nums1 than increment the nums1 min contribution
            // to be 1 more than nums1Ele
            else if (nums2Ele > 0 && nums1Ele < n && nums2[nums2Ele - 1] > nums1[nums1Ele]) {
                minEle = nums1Ele + 1;
            }
            // we are near to finding the median
            else {
                // here we need to find the last element if left half of the combined array
                // if no element from nums1 are to be choosen than choose the last element from
                // num2
                if (nums1Ele == 0) {
                    median = nums2[nums2Ele - 1];
                }
                // same goes for the other case where no element from num2 is to be choosen
                else if (nums2Ele == 0) {
                    median = nums1[nums1Ele - 1];
                } else {
                    // if both contribute than max of the last elements from nums1
                    // and nums2 is the median
                    median = Math.max(nums1[nums1Ele - 1], nums2[nums2Ele - 1]);
                }
                break;// as we found the median
            }
        }

        // if the count of 1 + othee is odd then only one median
        if ((n + m) % 2 == 1) {
            return (double) median;
        }

        // even than we have to find the next element
        // then two case arise that is all of the nums1 have
        // been used or all of nums2 have been used
        if (nums1Ele == n) {
            return (double) (median + nums2[nums2Ele]) / 2; // next of last from nums2
        }
        if (nums2Ele == m) {
            return (double) (median + nums1[nums1Ele]) / 2; // next of last from nums1
        }
        return (double) (median + Math.min(nums1[nums1Ele], nums2[nums2Ele])) / 2; // next element is obviously min of
        // next elements from nums1 and nums2
    }
}
