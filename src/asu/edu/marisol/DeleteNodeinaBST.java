package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class DeleteNodeinaBST {

    /**
     * Recursion approach DFS.
     *
     * @time-complexity - O (Log N).
     * @space-complexity - O (h).
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfsDeleteNode(root, key);
    }

    private int successor(TreeNode node) {
        node = node.right;
        while (node.left != null) node = node.left;
        return node.val;
    }

    private int predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) node = node.right;
        return node.val;
    }

    private TreeNode dfsDeleteNode(TreeNode node, int key) {
        if (node == null) return null;

        if (node.val > key) node.left = dfsDeleteNode(node.left, key);
        else if (node.val < key) node.right = dfsDeleteNode(node.right, key);
        else {
            if (node.left == null && node.right == null) node = null;
            else if (node.right != null) {
                int val = successor(node);
                node.val = val;
                node.right = dfsDeleteNode(node.right, val);
            } else {
                int val = predecessor(node);
                node.val = val;
                node.left = dfsDeleteNode(node.left, val);
            }
        }

        return node;
    }


}
