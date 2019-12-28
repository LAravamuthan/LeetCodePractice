package asu.edu.arav.amazon.interview.sorting;

import java.util.ArrayList;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 */
public class SearchinaSortedArrayofUnknownSize {


    public int search(ArrayList<Integer> reader, int target) {
        int lowerBound = 0;
        int upperboud = 1;

        while (reader.get(upperboud) < target) {

            lowerBound = upperboud;
            upperboud <<= 1;
        }

        while (lowerBound <= upperboud) {
            int mid = lowerBound + ((upperboud - lowerBound) >> 1);
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                lowerBound = mid + 1;
            } else {
                upperboud = mid - 1;
            }
        }

        return -1;
    }

}
