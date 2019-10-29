package asu.edu.aravl.medium;

import asu.edu.aravl.utility.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    int preOrderIdx;
    Map<Integer, Integer> valToIdxInorderMap = new HashMap<>();
    int[] inorder;
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null || preorder.length == 0 ||
                inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        preOrderIdx = 0;
        this.preorder = preorder;
        this.inorder = inorder;
        int inorderIdx = 0;
        for(int i : inorder){
            valToIdxInorderMap.put(i, inorderIdx++);
        }
        TreeNode root = dfshelper(0, inorder.length-1);
        return root;
    }

    public TreeNode dfshelper(int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preOrderIdx]);
        preOrderIdx++;
        node.left = dfshelper(left, valToIdxInorderMap.get(node.val) - 1);
        node.right = dfshelper(valToIdxInorderMap.get(node.val) + 1, right);
        return node;
    }
}
