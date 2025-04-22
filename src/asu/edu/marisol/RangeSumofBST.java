package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RangeSumofBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * DFS approach lets how to do this.
     *
     * @time-complexity - O (m) - magazine size
     * @space-complexity - O (1) - given only 26 characters
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    private int sum = 0;

    private void dfs(TreeNode node, int low, int high) {
        if (node == null) return;

        if (node.val >= low && node.val <= high) sum += node.val;
        if (node.val >= low) dfs(node.left, low, high);
        if (node.val <= high) dfs(node.right, low, high);
    }


    /**
     * BFS approach lets how to do this.
     *
     * @time-complexity - O (N) - magazine size
     * @space-complexity - O (max level) - given only 26 characters
     */
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int sum = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val >= low && node.val <= high) sum += node.val;
            if (node.left != null && node.val >= low) queue.offer(node.left);
            if (node.right != null && node.val <= high) queue.offer(node.right);
        }

        return sum;
    }
}
