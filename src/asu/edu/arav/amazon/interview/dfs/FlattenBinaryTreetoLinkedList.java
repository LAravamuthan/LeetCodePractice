package asu.edu.arav.amazon.interview.dfs;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreetoLinkedList {

    /**
     * @algo - DFS
     * @time-complexity - O(n)
     * @space-complexity - O(logn)
     */

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        dfs(root, null);
    }

    public TreeNode dfs(TreeNode node, TreeNode parent) {
        if (parent != null) {
            parent.right = node;
            parent.left = null;
        }
        TreeNode right = null;
        if (node.right != null) right = node.right;
        TreeNode parentNext = node;
        if (node.left != null) parentNext = dfs(node.left, parentNext);
        if (right != null) {
            parentNext = dfs(right, parentNext);
        }
        return parentNext;
    }

    public static void main(String[] args) {
        FlattenBinaryTreetoLinkedList f = new FlattenBinaryTreetoLinkedList();
        TreeNode in = new TreeNode(1);
        in.left = new TreeNode(2);
        in.right = new TreeNode(5);
        in.left.left = new TreeNode(3);
        in.left.right = new TreeNode(4);
        in.right.right = new TreeNode(6);

        f.flatten(in);
    }

}


