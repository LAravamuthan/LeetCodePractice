package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/maximum-binary-tree/
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null){
            return null;
        }
        return dfsMakeTree(nums, 0, nums.length - 1);
    }

    public TreeNode dfsMakeTree(int[] nums, int sIdx, int eIdx) {
        if (eIdx < sIdx) {
            return null;
        }

        if (sIdx == eIdx) {
            TreeNode node = new TreeNode(nums[sIdx]);
            return node;
        }

        int maxIdx = -1;

        for (int i = sIdx; i <= eIdx; i++) {
            if (maxIdx == -1 || nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        TreeNode node = new TreeNode(nums[maxIdx]);
        node.left = dfsMakeTree(nums, sIdx, maxIdx - 1);
        node.right = dfsMakeTree(nums, maxIdx + 1, eIdx);
        return node;
    }
}
