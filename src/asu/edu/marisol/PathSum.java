package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class PathSum {

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
     * DFS approach to get all leafs from root stop at first answer.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (h) -> height of the tree, can be 'n' in worst case.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        targetSum -= root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
