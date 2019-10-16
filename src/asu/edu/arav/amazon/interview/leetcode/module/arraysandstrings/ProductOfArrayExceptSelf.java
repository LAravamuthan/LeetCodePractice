package asu.edu.arav.amazon.interview.leetcode.module.arraysandstrings;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }
        // if the length == 1 then output is array with one element i.e 1
        if (nums.length == 1) {
            nums[0] /= nums[0];
            return nums;
        }
        // array the that contains the product till left of that index element value
        // in the source array
        int[] leftProduct = new int[nums.length];

        // array the that contains the product till right of that index element value
        // in the source array
        int[] rightProduct = new int[nums.length];

        // variable to store running left product
        int curLeftProduct = 1;
        // left product for first element is 1.
        leftProduct[0] = 1;

        // current left product would be product of previous element in the source array  * previous left product
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = nums[i - 1] * curLeftProduct;
            curLeftProduct = leftProduct[i];
        }

        // variable to store running right product
        int curRightProduct = 1;
        // right product for last element is 1.
        rightProduct[nums.length - 1] = 1;

        // current right product would be product of next element in the source array  * next right product
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProduct[i] = nums[i + 1] * curRightProduct;
            curRightProduct = rightProduct[i];
        }

        // here we iterate through the source array and for each element we find the multiply
        // left and right product value that in turn will give product without self
        for (int i = 0; i < nums.length; i++) {
            nums[i] = leftProduct[i] * rightProduct[i];
        }
        return nums;
    }

}
