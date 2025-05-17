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
     * TODO: Stack approach read karo.
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

    /**
     * Flatten the binary using recursion my own idea lets see it works or not.
     *
     * @time-complexity - O (N), no. of nodes.
     * @space-complexity - O (N)
     */
    public void flatten3(TreeNode root) {
        this.dummyHead = new TreeNode();
        this.prev = dummyHead;
        flattenNode2(root);
    }
    private TreeNode dummyHead;
    private TreeNode prev;

    private void flattenNode2(TreeNode node) {
        if (node == null) return;

        prev.right = node;
        prev = prev.right;
        TreeNode left = node.left;
        TreeNode right = node.right;
        flattenNode2(left);
        flattenNode2(right);
    }



    /**
     * Flatten the binary using iteration, Morris traversal  Practice.
     * TODO: Read morris traversal again
     *
     * @time-complexity - O (N), no. of nodes.
     * @space-complexity - O (1)
     */
    public void flatten4(TreeNode root) {

        while (root != null) {
            if (root.left != null) {
                TreeNode pred = root.left;
                while (pred.right != null) pred = pred.right;
                pred.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }


    /**
     * Flatten the binary using recursion.
     * Practice.
     *
     * @time-complexity - O (N), no. of nodes.
     * @space-complexity - O (N)
     */
    public void flatten5(TreeNode root) {
        flattenNodeTail(root);
    }

    private TreeNode flattenNodeTail(TreeNode node) {
        if (node == null) return null;

        TreeNode leftTail = flattenNodeTail(node.left);
        TreeNode rightTail = flattenNodeTail(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail == null ? leftTail : rightTail;
    }

}
