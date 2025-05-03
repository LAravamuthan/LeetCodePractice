package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class KthMissingPositiveNumber {

    /**
     * find the missing element like this, if the num is greater the current k that means, kth missing number came
     * so far and k itself is the answer.
     *
     * if k < num that means current k value cannot be the kth missing given a value num which is lesser or equal to
     * k contributes and k has to increase to a number which if not present will be the kth missing.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (1).
     */
    public int findKthPositive(int[] arr, int k) {
        for (int num : arr) {
            if (num <= k) k++;
            else return k;
        }

        return k;
    }


    /**
     * The binary search approach, how it works lets see. At each position k value increases right as per the previous approach
     * so at each point we know how many are missing based on index the number is at. The first element which has k missing elements before it
     * will given the answer. To make sense of it just imagine the previous approach, the fist element which is bigger than k +
     * elements crossed will be.
     *
     * @time-complexity - O (LogN).
     * @space-complexity - O (1).
     */
    public int findKthPositive2(int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (arr[mid] - (mid + 1) < k) left = mid + 1;
            else right = mid - 1;
        }

        return left + k;
    }
}
