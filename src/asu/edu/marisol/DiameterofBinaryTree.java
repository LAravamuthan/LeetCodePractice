package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class DiameterofBinaryTree {

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
     * DFS.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (h).
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfsMaxPath(root);
        return diameter;
    }

    private int diameter = 0;

    private int dfsMaxPath(TreeNode node) {
        if (node == null) return 0;
        int leftPathSize = dfsMaxPath(node.left);
        int rightPathSize = dfsMaxPath(node.right);

        diameter = Math.max(diameter, leftPathSize + rightPathSize);

        return Math.max(leftPathSize + 1, rightPathSize + 1);
    }
}
