package asu.edu.marisol;

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

    private Integer maxPathSumDfs(TreeNode node) {
        if (node == null) return null;

        Integer leftNodePathSum = maxPathSumDfs(node.left);
        Integer rightNodePathSum = maxPathSumDfs(node.right);

        int leftTreeBestPathSum = leftNodePathSum != null ? leftNodePathSum : 0;
        int rightTreeBestPathSum = rightNodePathSum != null ? rightNodePathSum : 0;
        int bestPathWithNode = Math.max(leftTreeBestPathSum + node.val, node.val + rightTreeBestPathSum);
        bestPathWithNode = Math.max(bestPathWithNode, node.val);
        int currentNodePathSum = leftTreeBestPathSum +  rightTreeBestPathSum + node.val;

        maxSum = Math.max(bestPathWithNode, currentNodePathSum);

        return bestPathWithNode;
    }

    private int maxSum = Integer.MIN_VALUE;

}
