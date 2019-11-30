package asu.edu.arav.impfacebook.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return nums;
        }

        int[] answer = new int[nums.length];

        answer[0] = 1;

        int l = 1;

        for (int i = 1; i < nums.length; i++) {
            answer[i] = l * nums[i - 1];
            l = answer[i];
        }

        int r = nums[nums.length - 1];

        for (int i = nums.length - 2; i > -1; i--) {
            answer[i] = answer[i] * r;
            r *= nums[i];
        }
        return answer;
    }
}
