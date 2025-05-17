package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BinaryTreeMaximumPathSum {

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
     * Doing with DFS method.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(h) height of the tree.
     */
    public int maxPathSum(TreeNode root) {

        maxPathSumDfs(root);
        return maxSum;
    }

    private int maxPathSumDfs(TreeNode node) {
        if (node == null) return 0;

        int leftNodePathSum = Math.max(maxPathSumDfs(node.left), 0);
        int rightNodePathSum = Math.max(maxPathSumDfs(node.right), 0);

        maxSum = Math.max(leftNodePathSum + rightNodePathSum + node.val, maxSum);

        return Math.max(node.val + leftNodePathSum, rightNodePathSum + node.val);
    }

    private int maxSum = Integer.MIN_VALUE;

    /**
     * Doing with DFS method.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(h) height of the tree.
     */
    public int maxPathSum2(TreeNode root) {
        dfsMax(root);
        return max;
    }

    private int max = Integer.MIN_VALUE;

    private int dfsMax(TreeNode node) {
        if (node == null) return 0;

        int leftMax = Math.max(dfsMax(node.left), 0);
        int rightMax = Math.max(dfsMax(node.right), 0);
        max = Math.max(max, leftMax + rightMax + node.val);

        return Math.max(leftMax + node.val, rightMax + node.val);
    }

}
