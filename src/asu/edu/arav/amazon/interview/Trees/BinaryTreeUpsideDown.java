package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/binary-tree-upside-down/
 */
public class BinaryTreeUpsideDown {

    /**
     * @algo - Recursive custom algo
     * @time-complexity - O(n)
     * @space-complexity - O(log n)
     */

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return root;
    }


    /**
     * @algo - Iterative custom algo
     * @time-complexity - O(n)
     * @space-complexity - O(1)
     */

    public TreeNode upsideDownBinaryTree1(TreeNode root) {

        if (root == null || root.left == null) return root;

        TreeNode curr = root;
        TreeNode next = null;
        TreeNode prev = null;
        TreeNode temp = null;

        while (curr != null) {
            next = curr.left;
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


}
