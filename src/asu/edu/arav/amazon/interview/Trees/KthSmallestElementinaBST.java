package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 1) {
            return -1;
        }
        List<Integer> elements = new ArrayList<Integer>();
        inOrderDfs(elements, root);
        return elements.get(k - 1);
    }

    public void inOrderDfs(List<Integer> elements, TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderDfs(elements, node.left);
        elements.add(node.val);
        inOrderDfs(elements, node.right);
    }

    // iterative version of inrderTraversal
    public int kthSmallest2(TreeNode root, int k) {
        if(root == null || k < 1){
            return -1;
        }

        Stack<TreeNode> st = new Stack<TreeNode>();

        TreeNode curr = root;
        while(curr != null || !st.isEmpty()){
            while (curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            if (--k == 0){
                return curr.val;
            }
            curr = curr.right;
        }

        return -1;
    }
}
