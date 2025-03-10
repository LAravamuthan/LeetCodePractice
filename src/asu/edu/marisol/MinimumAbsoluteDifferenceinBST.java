package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MinimumAbsoluteDifferenceinBST {

    class TreeNode {
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

    TreeNode prevNode = null;
    int minDiff = Integer.MAX_VALUE;

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);
        if (prevNode != null) {
            minDiff = Math.min(minDiff, node.val - prevNode.val);
        }
        prevNode = node;
        inOrder(node.right);
    }

    /**
     * DFS inorder traversal.
     *
     * @time-complexity - O (N), number of nodes in the tree.
     * @space-complexity - O (1)
     */
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

}
