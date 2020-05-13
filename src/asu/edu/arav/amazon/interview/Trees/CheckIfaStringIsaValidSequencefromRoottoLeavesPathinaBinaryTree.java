package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
 */
public class CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree {

    /**
     * @algo tree DFS
     * @time-complexity - O(n)
     * @space-complexity - O(height of the tree)
     */

    int[] arr = null;

    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) return false;
        if (arr == null || arr.length == 0) return true;
        this.arr = arr;
        return helper(0, root);
    }

    public boolean helper(int index, TreeNode node) {
        if (index == arr.length) return false;
        if (arr[index] != node.val) return false;
        if (index == arr.length - 1 && node.left == null && node.right == null) return true;
        boolean result = false;
        if (node.left != null) result = helper(index + 1, node.left);
        if (!result && node.right != null) result = helper(index + 1, node.right);
        return result;
    }

}
