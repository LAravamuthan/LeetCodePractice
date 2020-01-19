package asu.edu.arav.amazon.interview.sorting;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/first-bad-version/
 */
public class FirstBadVersion {

    /**
     * @algo binary search
     * @time-complexity - O(log N)
     * @space-complexity - O(1)
     */

    public int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isBadVersion(int i) {
        return false;
    }
}
