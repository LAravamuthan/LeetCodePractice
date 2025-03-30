package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class FlattenBinaryTreetoLinkedList {
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
     * Flatten the binary using recursion.
     *
     * @time-complexity - O (N), no. of nodes.
     * @space-complexity - O (N)
     */
    public void flatten(TreeNode root) {
        flattenNode(root);
    }

    private TreeNode flattenNode(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;

        TreeNode leftTail = flattenNode(node.left);
        TreeNode rightTail = flattenNode(node.right);
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail == null ? leftTail : rightTail;
    }


    /**
     * Flatten the binary using iteration, Morris traversal.
     * TODO: Read morris traversal again
     *
     * @time-complexity - O (N), no. of nodes.
     * @space-complexity - O (1)
     */
    public void flatten2(TreeNode root) {
        TreeNode node = root;

        while (node != null) {
            if (node.left != null) {
                // Finding the rightmost equivalent to finding largest element in left subtree in a BST.
                // This strategy is used to delete a element in the BST I guess, check it.
                TreeNode rightMost = node.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }

                rightMost.right = node.right;
                node.right = node.left;
                node.left = null;
            }

            // move to right side of the tree
            node = node.right;
        }
    }

}
