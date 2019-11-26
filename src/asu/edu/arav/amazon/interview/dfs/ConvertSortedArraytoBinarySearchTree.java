package asu.edu.arav.amazon.interview.dfs;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solution/
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return recursionStyleBTConstruction(0, nums.length - 1, nums);
    }

    public TreeNode recursionStyleBTConstruction(int idxLeft, int idxRight, int[] nums) {
        TreeNode ans = null;
        if (idxLeft <= idxRight) { // if the left index is greater than right it means tht there is no element left between them
            int mid = idxLeft + (idxRight - idxLeft) / 2;
            // make tree at using the mid element and pass the left portion for left tree and
            // right portion for its right tree
            ans = new TreeNode(nums[mid]);
            ans.left = recursionStyleBTConstruction(idxLeft, mid - 1, nums);
            ans.right = recursionStyleBTConstruction(mid + 1, idxRight, nums);
        }
        return ans;
    }

    public static void main(String[] args){

    }
}
