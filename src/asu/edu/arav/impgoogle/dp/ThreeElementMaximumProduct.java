package asu.edu.arav.impgoogle.dp;

public class ThreeElementMaximumProduct {
    public int maximumProduct(int[] nums) {
        if (nums.length < 3) {
            return 0;
        } else if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }

        int min1, min2;
        min1 = min2 = Integer.MAX_VALUE;

        int max1, max2, max3;
        max1 = max2 = max3 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
            if (nums[i] >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] >= max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }
        }
        return Math.max((max1 * max2 * max3), (min1 * min2 * max1));
    }


}
