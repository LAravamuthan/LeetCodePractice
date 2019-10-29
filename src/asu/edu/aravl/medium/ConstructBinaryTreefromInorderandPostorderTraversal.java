package asu.edu.aravl.medium;

import asu.edu.aravl.utility.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

    int postOrderArrayRootIdx;
    Map<Integer, Integer> valueToIdxInorderMap = new HashMap<>();
    int [] inorder;
    int [] postorder;


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || inorder.length != postorder.length){
            return null;
        }
        this.inorder = inorder;
        this.postorder = postorder;
        postOrderArrayRootIdx = postorder.length - 1;
        int idx = 0;
        for(int i : inorder){
            valueToIdxInorderMap.put(i, idx++);
        }
        TreeNode root = dfshelper(0, inorder.length - 1);
        return root;
    }

    public TreeNode dfshelper(int left, int right){
        if(left > right){
            return null;
        }
        TreeNode node = new TreeNode(postorder[postOrderArrayRootIdx]);
        postOrderArrayRootIdx--;
        node.right = dfshelper(valueToIdxInorderMap.get(node.val) + 1, right);
        node.left = dfshelper(left, valueToIdxInorderMap.get(node.val) - 1);
        return node;
    }
}
