package asu.edu.arav.amazon.interview.leetcode.module.TreesAndGraphs;

import asu.edu.aravl.utility.TreeNode;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */


public class LowestCommonAncestorofaBinaryTree {
    TreeNode ansNode = null;
    TreeNode p;
    TreeNode q;

    // First We will try the recursive way
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return ansNode;
        }
        this.p = p;
        this.q = q;
        dfsHelper(root);
        return ansNode;
    }

    public boolean dfsHelper(TreeNode root) {
        int self = 0, right = 0, left = 0;
        if (root == p || root == q) {
            self = 1;
        }
        if (root.left != null) {
            right = dfsHelper(root.left) ? 1 : right;
        }
        if (root.right != null) {
            left = dfsHelper(root.right) ? 1 : left;
        }
        if (right + left + self >= 2) {
            ansNode = root;
        }
        return self + left + right > 0;
    }

    // Second let us try the recursive way
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();
        Set<TreeNode> ancestors = new HashSet<>();
        Stack<TreeNode> st = new Stack<>();
        nodeToParent.put(root, null);
        st.push(root);
        // remember p and q are sure to be present and hence st.isEmpty() need not be done
        while (!nodeToParent.containsKey(p) || !nodeToParent.containsKey(q)) {
            TreeNode node = st.pop();
            if (node.left != null){
                nodeToParent.put(node.left, node);
                st.push(node.left);
            }
            if (node.right != null){
                nodeToParent.put(node.right, node);
                st.push(node.right);
            }
        }
        while(q != null){
            ancestors.add(q);
            q = nodeToParent.get(q);
        }
        while(!ancestors.contains(p)){
            p  = nodeToParent.get(p);
        }
        return p;
    }
}
