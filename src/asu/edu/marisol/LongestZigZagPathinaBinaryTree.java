package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class LongestZigZagPathinaBinaryTree {

    /**
     * Zig-zag traversal at each node how though ?. Got the answer for a child node, direction to go is controlled by
     * the parent. If we reached the child by going right from parent, the child go only go left to prolong the path.
     * Other option it has to start a new path going to right.
     *
     * Note: for the root node, we choose one direction, the other direction is covered by start a new path with size 1.
     *
     * @time-complexity - O (N), given we might move on idx twice.
     * @space-complexity - O (N), where k no. of unique characters (max of 26) and n no. of characters.
     */
    public int longestZigZag(TreeNode root) {
        this.maxPathSum = -1;
        if (root == null) return -1;
        dfsMaxPath(root, true, 0);
        return maxPathSum;
    }

    private int maxPathSum;

    private void dfsMaxPath(TreeNode node, boolean goLeft, int steps) {
        if (node == null) return;
        maxPathSum = Math.max(maxPathSum, steps);

        if (goLeft) {
            dfsMaxPath(node.left, false, steps + 1);
            dfsMaxPath(node.right, true, 1);
        } else {
            dfsMaxPath(node.right, true, steps + 1);
            dfsMaxPath(node.left, false, 1);
        }
    }
}
