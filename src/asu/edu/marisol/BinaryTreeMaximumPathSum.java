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

}
