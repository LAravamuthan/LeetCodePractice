package asu.edu.marisol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) inOrderMap.put(inorder[i], i);
        postOrderIdx = postorder.length - 1;
        return postRecur(postorder, 0, postorder.length - 1);
    }

    private int postOrderIdx;
    Map<Integer, Integer> inOrderMap = new HashMap<>();

    private TreeNode postRecur(int[] postorder, int left, int right) {
        if (left > right) return null;

        int nodeVal = postorder[postOrderIdx--];
        TreeNode node = new TreeNode(nodeVal);
        node.right = postRecur(postorder, inOrderMap.get(nodeVal) + 1, right);
        node.left = postRecur(postorder, left, inOrderMap.get(nodeVal) - 1);
        return node;
    }


    /**
     * Recursive building approach practice .
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {

        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inOrderMap.put(inorder[i], i);
        postOrderIdx = postorder.length - 1;
        return recursion(postorder, 0, postorder.length - 1, inOrderMap);
    }


    private TreeNode recursion(int[] postOrder, int left, int right, Map<Integer, Integer> inOrderMap) {
        if (left > right) return null;

        TreeNode node = new TreeNode(postOrder[postOrderIdx--]);
        node.right = recursion(postOrder, inOrderMap.get(node.val) + 1, right, inOrderMap);
        node.left = recursion(postOrder, left, inOrderMap.get(node.val) - 1, inOrderMap);

        return node;

    }
}
