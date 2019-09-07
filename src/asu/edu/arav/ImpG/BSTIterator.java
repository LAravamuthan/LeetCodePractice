package asu.edu.arav.ImpG;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */


import asu.edu.AravL.utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    public Queue<TreeNode> inOrderQueue = new LinkedList<TreeNode>();
    public void inorder(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0) {

            /* Reach the left most Node of the
            curr Node */
            while (curr != null) {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = s.pop();
            inOrderQueue.add(curr);
            curr = curr.right;
        }
    }

    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return inOrderQueue.remove().val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return (inOrderQueue.size() > 0);
    }
}
