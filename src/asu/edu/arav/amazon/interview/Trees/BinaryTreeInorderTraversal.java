package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> ansList = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode curr = root;
        while (!st.isEmpty() || curr != null) {
            while (curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            ansList.add(curr.val);
            curr = curr.right;
        }

        return ansList;
    }


    List<Integer> ansList = new ArrayList<>();
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return ansList;
        }
        if(root.left != null){
            inorderTraversal1(root.left);
        }
        ansList.add(root.val);
        if(root.right != null){
            inorderTraversal1(root.right);
        }
        return ansList;
    }
}
