package asu.edu.arav.amazon.interview.sorting;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class CapacityToShipPackagesWithinDDays {

    /**
     * @algo - Binary Search
     * @time-complexity - (n * log(totalWeights - Max))
     * @space-complexity - O(1)
     */


    public int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length == 0) return -1;
        /* l - (max of all weights) lowest capacity, r - sum(all weights) highest capacity */
        int l = 0, r = 0;

        for (int i = 0; i < weights.length; i++) {
            l = Math.max(l, weights[i]);
            r += weights[i];
        }

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int days = 1, curLoad = 0;
            for (int w : weights) {
                if (curLoad + w > mid) {
                    days++;
                    curLoad = 0;
                }
                curLoad += w;
            }
            if (days > D) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays c = new CapacityToShipPackagesWithinDDays();
        int[] in = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        c.shipWithinDays(in, 5);
    }

}
