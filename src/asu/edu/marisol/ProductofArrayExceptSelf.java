package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ProductofArrayExceptSelf {

    /**
     * Left products and right products method, two passes but optimized to use O(1) extra space.
     * Also thing to note is the answer array is not counted as extra space.
     *
     * @time-complexity - O (2n ~ n).
     * @space-complexity - O (1).
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];

        products[0] = 1;

        for (int i = 1; i < n; i++) {
            products[i] = products[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            products[i] = products[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return products;
    }

}
