package asu.edu.marisol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

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
     * Recursive building approach.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return recursiveTreeNode(preorder, 0, inorder.length - 1);
    }

    int preorderIndexToProcess = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    private TreeNode recursiveTreeNode(int[] preorder, int left, int right) {
        if (left > right) return null;

        TreeNode node = new TreeNode(preorder[preorderIndexToProcess++]);
        node.left = recursiveTreeNode(preorder, left, inorderMap.get(node.val) - 1);
        node.right = recursiveTreeNode(preorder, inorderMap.get(node.val) + 1, right);
        return node;
    }
}
